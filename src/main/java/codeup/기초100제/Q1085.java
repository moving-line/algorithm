package codeup.기초100제;

import java.util.Scanner;

public class Q1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int s = sc.nextInt();

        double dataSize = ((((double)h * b * c * s) / 8) / 1024) / 1024;

        System.out.printf("%.1f MB", dataSize);
    }
}