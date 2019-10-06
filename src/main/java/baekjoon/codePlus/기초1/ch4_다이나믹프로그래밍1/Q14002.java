package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Arrays;
import java.util.Scanner;

public class Q14002 {
    private static int[] A;
    private static int[] dp;
    private static int[] track;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        dp = new int[N];
        track = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.fill(dp, 1);
        Arrays.fill(track, -1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    track[i] = j;
                }
            }
        }

        int length = 0;
        int indexOfMax = 0;

        for (int i = 0; i < N; i++) {
            if(length < dp[i]) {
                length = dp[i];
                indexOfMax = i;
            }
        }

        System.out.println(length);
        back(indexOfMax);
    }

    private static void back(int index) {
        if (index == -1) {
            return;
        }
        back(track[index]);
        System.out.print(A[index] + " ");
    }
}
