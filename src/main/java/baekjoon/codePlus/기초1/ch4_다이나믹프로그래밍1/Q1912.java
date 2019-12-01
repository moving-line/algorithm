package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Arrays;
import java.util.Scanner;

public class Q1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }

        long[] dp = new long[n];
        dp[0] = seq[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]);
        }

        System.out.println(Arrays.stream(dp).max().getAsLong());
    }
}
