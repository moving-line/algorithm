package baekjoon.codePlus.기초1.ch3_수학1;

import java.util.Scanner;

public class Q1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int size = input.length();

        if (size % 3 == 1) {
            System.out.print(input.charAt(0));
        } else if (size % 3 == 2) {
            System.out.print((input.charAt(0) - '0') * 2 + (input.charAt(1) - '0'));
        }

        for (int i = size % 3; i < size; i += 3) {
            System.out.print((input.charAt(i) - '0') * 4 + (input.charAt(i + 1) - '0') * 2 + (input.charAt(i + 2) - '0'));
        }

        System.out.println();
    }
}
