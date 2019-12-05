package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[][] = new int[N + 1][3];

        sc.nextLine();
        for (int i = 1; i <= N; i++) {
            String[] cost = sc.nextLine().split(" ");
            int red = Integer.parseInt(cost[0]);
            int green = Integer.parseInt(cost[1]);
            int blue = Integer.parseInt(cost[2]);

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;
        }

        int result = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.println(result);
    }
}
