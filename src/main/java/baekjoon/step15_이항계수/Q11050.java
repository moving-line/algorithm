/*
문제
자연수 N과 정수 K가 주어졌을 때 이항 계수 (N K) 를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 0 ≤ K ≤ N)

출력
(N K) 를 출력한다. (nCk)
 */

package baekjoon.step15_이항계수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(getf(N) / (getf(K) * getf(N - K)));
    }

    private static int getf(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) factorial *= i;

        return factorial;
    }

//     재귀
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int K = Integer.parseInt(input[1]);
//
//        System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
//    }
//
//    private static int factorial(int num) {
//        if(num < 2) return 1;
//        return factorial(num - 1) * num;
//    }
}
