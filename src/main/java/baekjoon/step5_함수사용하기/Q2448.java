/*
문제
예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력
첫째 줄에 N이 주어진다. N은 항상 3×2^k 수이다. (3, 6, 12, 24, 48, ...) (k ≤ 10)

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.

                        [예제]

 1                        *
 2                       * *
 3                      *****
 4                     *     *
 5                    * *   * *
 6                   ***** *****
 7                  *           *
 8                 * *         * *
 9                *****       *****
10               *     *     *     *
11              * *   * *   * *   * *
12             ***** ***** ***** *****
13            *                       *
14           * *                     * *
15          *****                   *****
16         *     *                 *     *
17        * *   * *               * *   * *
18       ***** *****             ***** *****
19      *           *           *           *
20     * *         * *         * *         * *
21    *****       *****       *****       *****
22   *     *     *     *     *     *     *     *
23  * *   * *   * *   * *   * *   * *   * *   * *
24 ***** ***** ***** ***** ***** ***** ***** *****
25                        .
26                        .
27                        .

*/

package baekjoon.step5_함수사용하기;

import java.io.*;
import java.util.Scanner;

public class Q2448 {
    private static char[][] paper;

//    첫번째 풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        outer:
        while (true) {
            for (int i = 0; i <= 10; i++) if (N == 3 * Math.pow(2, i)) break outer;
            N = sc.nextInt();
        }

        paper = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                paper[i][j] = ' ';
            }
        }

        drawStar(0, N - 1, N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(paper[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void drawStar(int y, int x, int N) {
        if (N == 3) {
            paper[y][x] = '*';
            paper[y + 1][x - 1] = paper[y + 1][x + 1] = '*';
            paper[y + 2][x - 2] = paper[y + 2][x - 1] = paper[y + 2][x] = paper[y + 2][x + 1] = paper[y + 2][x + 2] = '*';
            return;
        }

        drawStar(y, x, N / 2); // (0,5,3)
        drawStar(y + N / 2, x - N / 2, N / 2);
        drawStar(y + N / 2, x + N / 2, N / 2);
    }

//    두번째 풀이
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(bf.readLine());
//
//        outer:
//                while (true) {
//            for (int i = 0; i <= 10; i++) if (N == 3 * Math.pow(2, i)) break outer;
//            N = Integer.parseInt(bf.readLine());
//        }
//
//        paper = new char[N][2 * N - 1];
//            for (int i = 0; i < N; i++) {
//            for (int j = 0; j < 2 * N - 1; j++) {
//                paper[i][j] = 32;
//            }
//        }
//
//        drawStar(0, N - 1, N);
//
//            for (int i = 0; i < N; i++) {
//            for (int j = 0; j < 2 * N - 1; j++) {
//                bw.write(paper[i][j]);
//            }
//            bw.newLine();
//        }
//
//            bw.flush();
//            bw.close();
//    }
}