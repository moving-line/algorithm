package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[N + 1][3];
        dp[1][0] = 1; // 사자 없음
        dp[1][1] = 1; // 사자 왼쪽
        dp[1][2] = 1; // 사자 오른쪽

        long remain = 9901;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (((dp[i - 1][0] + dp[i - 1][1]) % remain) + dp[i - 1][2]) % remain;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % remain;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % remain;
        }

        System.out.println((((dp[N][0] + dp[N][1]) % remain) + dp[N][2]) % remain);
    }
}
