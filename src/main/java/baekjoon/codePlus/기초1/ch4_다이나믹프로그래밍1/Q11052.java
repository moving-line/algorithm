package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q11052 {
    // Top-down .. 약간 난해함
    private static int[] dp;
    private static int[] Ps;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Ps = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Ps[i] = sc.nextInt();
        }

        dp = new int[N + 1];
        System.out.println(card(N));
    }

    private static int card(int num) {
        if (dp[num] > 0) {
            return dp[num];
        }
        if (num == 1) {
            dp[num] = Ps[num];
            return dp[num];
        }

        for (int i = 1; i <= num; i++) {
            dp[num] = (card(num - i) + Ps[i] > dp[num]) ?
                    dp[num - i] + Ps[i] : dp[num];
        }

        return dp[num];
    }

    // Bottom-up
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Ps = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Ps[i] = sc.nextInt();
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + Ps[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
