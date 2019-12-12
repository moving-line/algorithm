package baekjoon.codePlus.기초1.ch4_다이나믹프로그래밍1;

import java.util.Arrays;
import java.util.Scanner;

public class Q11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] str = sc.nextLine().split(" ");

        int[] A = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();

        int[] dpLeft = new int[N];
        for (int i = 0; i < N; i++) {
            dpLeft[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dpLeft[i] < dpLeft[j] + 1) {
                    dpLeft[i] = dpLeft[j] + 1;
                }
            }
        }

        int[] dpRight = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            dpRight[i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (A[i] > A[j] && dpRight[j] + 1 > dpRight[i]) {
                    dpRight[i] = dpRight[j] + 1;
                }
            }
        }

        int sum = dpLeft[0] + dpRight[0] - 1;
        for (int i = 0; i < N; i++) {
            if (sum < dpLeft[i] + dpRight[i] - 1) {
                sum = dpLeft[i] + dpRight[i] - 1;
            }
        }
        System.out.println(sum);
    }
}