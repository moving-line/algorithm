package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q11727 {
    // Top-down
    private static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];

        System.out.println(calculate(n));
    }

    private static int calculate(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        if (dp[num] != 0) {
            return dp[num];
        }

        dp[num] = (calculate(num - 2) * 2 + calculate(num - 1)) % 10007;
        return dp[num];
    }

    // Bottom-up
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}
