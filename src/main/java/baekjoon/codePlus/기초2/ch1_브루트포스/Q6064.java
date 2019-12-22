package baekjoon.codePlus.기초2.ch1_브루트포스;

import java.util.Scanner;

public class Q6064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int M = sc.nextInt(), N = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();

            boolean hasAnswer = false;
            for (int j = x; j <= N * M; j += M) {
                if(j % N == y || (j % N == 0 && N == y)) {
                    System.out.println(j);
                    hasAnswer = true;
                    break;
                }
            }
            if(!hasAnswer) {
                System.out.println(-1);
            }
        }
    }

    // 시간초과풀이
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int M = sc.nextInt(), N = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            int k = 1, X = 1, Y = 1;

            while (X != x || Y != y) {
                X = (X > M) ? 1 : X + 1;
                Y = (Y > M) ? 1 : Y + 1;
                k++;

                if (k >= M * N) {
                    k = -1;
                    break;
                }
            }

            System.out.println(k);
        }
    }
}
