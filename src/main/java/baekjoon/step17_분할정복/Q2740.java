/*
문제
N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.

입력
첫째 줄에 행렬 A의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 순서대로 주어진다. 그 다음 줄에는 행렬 B의 크기 M과 K가 주어진다. 이어서 M개의 줄에 행렬 B의 원소 K개가 차례대로 주어진다. N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

출력
첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.
 */

package baekjoon.step17_분할정복;

import java.util.Scanner;

public class Q2740 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] inputA = sc.nextLine().split(" ");
        int N_A = Integer.parseInt(inputA[0]);
        int M_A = Integer.parseInt(inputA[1]);

        int[][] A = new int[N_A][M_A];

        for (int i = 0; i < N_A; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < M_A; j++) {
                A[i][j] = Integer.parseInt(input[j]);
            }
        }

        String[] inputB = sc.nextLine().split(" ");
        int N_B = Integer.parseInt(inputB[0]);
        int M_B = Integer.parseInt(inputB[1]);

        int[][] B = new int[N_B][M_B];

        for (int i = 0; i < N_B; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < M_B; j++) {
                B[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N_A ; i++) {
            for (int j = 0; j < M_B; j++) {
                int sum = 0;
                for (int k = 0; k < N_B; k++) {
                    sum += A[i][k] * B[k][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
