/*
문제
자연수 N과 정수 K가 주어졌을 때 이항 계수 (N K) 를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ K ≤ N)

출력
(N K) 를 10,007로 나눈 나머지를 출력한다. (nCk)
 */


package baekjoon.step14_수학3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(factorial(N, K));
    }

    private static BigInteger factorial(int N, int K) {
        BigInteger numeratorF = BigInteger.ONE;
        BigInteger denominatorF = BigInteger.ONE;

        int startNum = (K > N - K) ? K + 1 : N - K + 1;
        int subNum = (K > N - K) ? N - K : K;

        for (int i = startNum; i <= N; i++) {
            numeratorF = numeratorF.multiply(BigInteger.valueOf(i));
        }

        for (int i = 1; i <= subNum; i++) {
            denominatorF = denominatorF.multiply(BigInteger.valueOf(i));
        }

        return numeratorF.divide(denominatorF).mod(BigInteger.valueOf(10007));
    }

//    동적계획법
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int K = Integer.parseInt(input[1]);
//
//        int[][] list = new int[1001][1001];
//        list[1][0] = list[1][1] = 1;
//
//        for (int i = 2; i <= N; i++) {
//            for (int j = 0; j <= i; j++) {
//                list[i][j] = ((i == j || j == 0) ? 1 : list[i-1][j-1] + list[i-1][j]) % 10007;
//            }
//        }
//
//        System.out.println(list[N][K]);
//    }
}