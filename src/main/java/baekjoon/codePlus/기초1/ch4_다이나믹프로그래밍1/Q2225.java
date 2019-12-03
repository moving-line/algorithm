package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long mod = 1000000000L;

        long[][] dp = new long[K + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % mod;
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}