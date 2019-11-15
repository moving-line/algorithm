package codeup.기초100제;

import java.util.Scanner;

public class Q1082 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hex = Integer.parseInt(sc.next(), 16);
        for (int i = 1; i < 16; i++) {
            System.out.printf("%X*%X=%X\n", hex, i, hex * i);
        }
    }
}
