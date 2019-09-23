package baekjoon.codePlus.기초1.ch3_수학1.참고;

import java.util.Scanner;

public class Q2745 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = Integer.parseInt(sc.next());

        int number = 0;
        for (int i = N.length() - 1; i >= 0; i--) {
            int c = N.charAt(i) > '9' ? N.charAt(i) - 55 : N.charAt(i) - '0';
            number += c * Math.pow(B, (N.length() - 1) - i);
        }
        System.out.println(number);
    }
}
