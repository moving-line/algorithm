package baekjoon.codePlus.기초1.ch2_자료구조1.참고;

import java.util.Scanner;

public class Q10824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.next();
        String num2 = sc.next();
        String num3 = sc.next();
        String num4 = sc.next();

        System.out.println(Long.parseLong(num1 + num2) + Long.parseLong(num3 + num4));
    }
}
