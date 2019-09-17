package baekjoon.codePlus.기초1.ch2_자료구조1.참고;

import java.util.Scanner;

public class Q10820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String sentence = sc.nextLine();
            int lower = 0, upper = 0, space = 0, number = 0;
            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if (c == ' ') {
                    space++;
                } else if (c >= '0' && c <= '9') {
                    number++;
                } else if (c >= 'A' && c <= 'Z') {
                    upper++;
                } else if (c >= 'a' && c <= 'z') {
                    lower++;
                }
            }

            System.out.printf("%d %d %d %d\n", lower, upper, number, space);
        }
    }
}