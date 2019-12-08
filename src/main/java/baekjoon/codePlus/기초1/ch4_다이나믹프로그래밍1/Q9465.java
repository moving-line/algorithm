package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q9465 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            sc.nextLine();

            int[][] dp = new int[n][3];
            int[][] sticker = new int[n][2];
            String[] row1 = sc.nextLine().split(" ");
            String[] row2 = sc.nextLine().split(" ");

            for (int j = 0; j < n; j++) {
                sticker[j][0] = Integer.parseInt(row1[j]);
                sticker[j][1] = Integer.parseInt(row2[j]);
            }

            dp[0][1] = sticker[0][0];
            dp[0][2] = sticker[0][1];

            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.max(Math.max(dp[j - 1][0], dp[j - 1][1]), dp[j - 1][2]);
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + sticker[j][0];
                dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]) + sticker[j][1];
            }

            System.out.println(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
        }
    }
}