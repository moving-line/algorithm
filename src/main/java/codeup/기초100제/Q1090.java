package codeup.기초100제;

import java.util.Scanner;

public class Q1090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();

        long result = a;
        for (int i = 2; i <= n; i++) {
            result *= r;
        }

        System.out.println(result);
    }
}
