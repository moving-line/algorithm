package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q15990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = 1000000009;
        int limit = 100000;
        int T = sc.nextInt();
        int[][] dp = new int[limit + 1][3];

        dp[1][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for (int j = 4; j <= limit; j++) {
            dp[j][0] = (dp[j - 1][1] + dp[j - 1][2]) % mod;
            dp[j][1] = (dp[j - 2][0] + dp[j - 2][2]) % mod;
            dp[j][2] = (dp[j - 3][0] + dp[j - 3][1]) % mod;
        }

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println((((dp[n][0] + dp[n][1]) % mod)  + dp[n][2]) % mod);
        }
    }
}