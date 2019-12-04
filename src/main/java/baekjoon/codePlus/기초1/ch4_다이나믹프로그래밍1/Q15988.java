package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q15988 {
    private static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        dp = new long[1000001];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        int mod = 1000000009;

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            if (dp[n] != 0) {
                System.out.println(dp[n]);
                continue;
            }

            for (int j = 4; j <= n; j++) {
                dp[j] = ((dp[j - 1] + dp[j - 2]) % mod + dp[j - 3]) % mod;
            }
            System.out.println(dp[n]);
        }
    }
}
