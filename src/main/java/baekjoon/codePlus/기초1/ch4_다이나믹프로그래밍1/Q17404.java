package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q17404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cost[][] = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int max = 1000 * 1000 + 1;
        int dp[][] = new int[N + 1][3];

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                dp[1][i] = (i == k) ? cost[1][i] : 1001;
            }

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if(i == k) continue;
                max = Math.min(max, dp[N][i]);
            }
        }

        System.out.println(max);
    }
}