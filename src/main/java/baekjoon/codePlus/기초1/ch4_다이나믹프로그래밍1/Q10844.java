package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Scanner;

public class Q10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long [][] dp = new long[101][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        long mod = 1000000000L;

        for (int i = 2; i <= 100; i++) {
            for (int j = 1; j < 9; j++) {
                dp[i][j] = ((dp[i - 1][j - 1]) % mod + (dp[i - 1][j + 1]) % mod) % mod;
            }
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[N][i]) % mod;
        }
        System.out.println(result % mod);
    }
}
