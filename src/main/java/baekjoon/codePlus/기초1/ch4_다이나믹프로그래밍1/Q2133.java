package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        dp[0] = 1;

        for (int i = 2; i <= N; i += 2) {
            dp[i] = 3 * dp[i - 2];
            for (int j = 4; j <= i; j += 2) {
                dp[i] += 2 * dp[i - j];
            }
        }

        System.out.println(dp[N]);
    }
}
