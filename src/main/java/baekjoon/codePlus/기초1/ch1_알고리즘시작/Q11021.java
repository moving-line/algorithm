package baekjoon.codePlus.기초1.ch1_알고리즘시작;

import java.util.Scanner;

public class Q11021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int a, b;

        for (int i = 0; i < T; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println("Case #" + i + ": " + (a + b));
        }
    }
}
