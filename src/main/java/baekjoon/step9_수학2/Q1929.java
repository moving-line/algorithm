/*
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */

package baekjoon.step9_수학2;

import java.io.*;

public class Q1929 {
    public static void main(String[] args) throws IOException {
//        첫번째 풀이 (제곱근과 에라토스테네스의 체의 반반치킨)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();
        int[] array = new int[N + 1];

        outer : for (int i = 2; i <= N; i++) {
            if (array[i] > 0) continue;

            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    array[i] = 2;
                    continue outer;
                }
            }
            array[i] = 1;
            for (int j = i + i; j <= N; j += i) {
                array[j] = 2;
            }
        }
        array[1] = 2;

        for (int i = M; i <= N; i++) {
            if (array[i] == 1) sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

//        두번째 풀이. 순수한 에라토스테네스의 체 활용한 극강효율
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] input = br.readLine().split(" ");
//        int M = Integer.parseInt(input[0]);
//        int N = Integer.parseInt(input[1]);
//
//        boolean[] array = new boolean[N + 1];
//        array[1] = true;
//
//        for (int i = 2; i < array.length; i++) {
//            if(array[i]) continue;
//            for (int j = 2; i * j < array.length; j++) {
//                array[i * j] = true;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = M; i <= N; i++) {
//            if (!array[i]) sb.append(i).append("\n");
//        }
//        System.out.println(sb.toString());
    }
}