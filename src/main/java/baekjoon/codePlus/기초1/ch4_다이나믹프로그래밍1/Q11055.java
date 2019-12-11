package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Arrays;
import java.util.Scanner;

public class Q11055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");

        int[] A = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];
        dp[0] = A[0];
        for (int i = 1; i < N; i++) {
            dp[i] = A[i];
            for (int j = 0; j < i; j++) {
                if(A[j] < A[i] && dp[i] < dp[j] + A[i]) {
                    dp[i] = dp[j] + A[i];
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}