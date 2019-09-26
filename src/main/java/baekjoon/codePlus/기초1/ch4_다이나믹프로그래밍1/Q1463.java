package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q1463 {
    // Top-down
    private static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[N + 1];

        System.out.println(calculate(N));
    }

    private static int calculate(int num) {
        if (num == 1) {
            return 0;
        }
        if (dp[num] > 0) {
            return dp[num];
        }

        dp[num] = calculate(num - 1) + 1;
        if (num % 2 == 0) {
            if (dp[num] > calculate(num / 2) + 1) {
                dp[num] = calculate(num / 2) + 1;
            }
        }
        if (num % 3 == 0) {
            if (dp[num] > calculate(num / 3) + 1) {
                dp[num] = calculate(num / 3) + 1;
            }
        }

        return dp[num];
    }

    //Bottom-up
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] dp = new int[N + 1];
//        dp[1] = 0;
//
//        for (int i = 2; i <= N; i++) {
//            dp[i] = dp[i - 1] + 1;
//            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
//                dp[i] = dp[i / 2] + 1;
//            }
//            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
//                dp[i] = dp[i / 3] + 1;
//            }
//        }
//        System.out.println(dp[N]);
//    }
}