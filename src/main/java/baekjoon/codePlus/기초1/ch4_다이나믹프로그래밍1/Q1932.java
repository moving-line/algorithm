package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] triangle = new long[n][];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            triangle[i] = new long[input.length];
            for (int j = 0; j < input.length; j++) {
                triangle[i][j] = Integer.parseInt(input[j]);
            }
        }

        long[][] dp = new long[n][];
        dp[0] = new long[1];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            dp[i] = new long[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }

        long max = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            if (dp[n - 1][i] > max) {
                max = dp[n - 1][i];
            }
        }
        System.out.println(max);
    }
}
