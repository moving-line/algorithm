package codeup.기초100제;

import java.util.Scanner;

public class Q1046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(a + b + c);
        System.out.printf("%.1f",((a + b + c) / 3.0));
    }
}
