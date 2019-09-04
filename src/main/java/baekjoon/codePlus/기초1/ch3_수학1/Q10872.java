package baekjoon.codePlus.기초1.ch3_수학1;

import java.util.Scanner;

public class Q10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int result = 1;
        for (int i = 2; i <= N; i++) {
            result *= i;
        }

        System.out.println(result);
    }
}
