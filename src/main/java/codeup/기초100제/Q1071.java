package codeup.기초100제;

import java.util.Scanner;

public class Q1071 {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int num = sc.nextInt();

        go(num);
    }

    private static void go(int num) {
        if (num != 0) {
            System.out.println(num);
            go(sc.nextInt());
        }
    }
}
