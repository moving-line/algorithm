package baekjoon.codePlus.기초1.ch3_수학1.참고;

import java.util.Scanner;

public class Q11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 2; i * i <= N; i++) {
            while(N % i == 0) {
                N /= i;
                System.out.println(i);
            }
        }

        if(N > 1) {
            System.out.println(N);
        }
    }
}
