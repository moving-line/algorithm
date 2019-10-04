package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Arrays;
import java.util.Scanner;

public class Q2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[91][2];
        dp[1][1] = 1;

        for (int i = 1; i <= 90; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        System.out.println(Arrays.stream(dp[N]).sum());
    }
}
