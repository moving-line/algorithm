package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q9095 {
    // Top-down
    private static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            dp = new int[n + 1];

            System.out.println(plus(n));
        }
    }

    private static int plus(int num) {
        if (num == 1) {
            dp[1] = 1;
        } else if (num == 2) {
            dp[2] = 2;
        } else if (num == 3) {
            dp[3] = 4;
        }

        if (dp[num] > 0) {
            return dp[num];
        }

        dp[num] = plus(num - 1) + plus(num - 2) + plus(num - 3);
        return dp[num];
    }

    // Bottom-up
//    public static void main2(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//
//        for (int i = 0; i < T; i++) {
//            int n = sc.nextInt();
//            int[] dp = new int[n + 1];
//            dp[1] = 1;
//            if (n >= 2) dp[2] = 2;
//            if (n >= 3) dp[3] = 4;
//
//            for (int j = 4; j <= n; j++) {
//                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
//            }
//            System.out.println(dp[n]);
//        }
//    }
}
