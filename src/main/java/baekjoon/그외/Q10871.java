/*
문제
정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)

둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.

출력
X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
 */

package baekjoon.그외;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Q10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NX = br.readLine().split(" ");
        int N = Integer.parseInt(NX[0]);
        int X = Integer.parseInt(NX[1]);
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 방법1 : Stream + join
        System.out.println(Arrays.stream(A).filter(i -> i < X).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        // 방법2 : 조건문을 이용한 루프문
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int a : A) {
            if (a < X) {
                bw.write(String.valueOf(a));
                bw.write(" ");
            }
        }
        bw.flush();
        bw.close();
    }
}
