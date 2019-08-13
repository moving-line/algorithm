package baekjoon.codePlus.기초1.ch1_알고리즘시작;

import java.util.Scanner;

public class Q10952 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b;

        do {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a + b != 0) System.out.println(a + b);
        }
        while (a != 0 && b != 0);
    }
}
