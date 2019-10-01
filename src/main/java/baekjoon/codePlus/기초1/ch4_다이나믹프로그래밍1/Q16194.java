package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q16194 {
    // Top-down .. 약간 난해함
    private static int[] dp;
    private static int[] Ps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Ps = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Ps[i] = sc.nextInt();
            dp[i] = Integer.MAX_VALUE;
        }

        System.out.println(card(N));
    }

    private static int card(int num) {
        if (dp[num] != Integer.MAX_VALUE) {
            return dp[num];
        }
        if (num == 1) {
            dp[num] = Ps[num];
            return dp[num];
        }

        for (int i = 1; i <= num; i++) {
            if(card(num - i) + Ps[i] < dp[num]) {
                dp[num] = card(num - i) + Ps[i];
            }
        }

        return dp[num];
    }

    // Bottom-up
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            P[i] = sc.nextInt();
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i - j] + P[j], dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
