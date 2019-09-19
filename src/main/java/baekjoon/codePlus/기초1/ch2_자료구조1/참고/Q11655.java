package baekjoon.codePlus.기초1.ch2_자료구조1.참고;

import java.util.Scanner;

public class Q11655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(ROT13(input));
    }

    private static String ROT13(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c + 13 > 'z') {
                    sb.append((char) (c - 13));
                } else {
                    sb.append((char) (c + 13));
                }
            } else if (c >= 'A' && c <= 'Z') {
                if (c + 13 > 'Z') {
                    sb.append((char) (c - 13));
                } else {
                    sb.append((char) (c + 13));
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
