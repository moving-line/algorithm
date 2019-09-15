package baekjoon.codePlus.기초1.ch2_자료구조1.참고;

import java.util.Scanner;

public class Q10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] S = sc.nextLine().toCharArray();
        int[] count = new int[26];

        for (char c : S) {
            count[c - 97]++;
        }

        for (int c : count) {
            System.out.print(c + " ");
        }
    }
}
