package codeup.기초100제;

import java.util.Scanner;

public class Q1072 {
    private static Scanner sc;
    private static int n;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        n = sc.nextInt();
        go();
    }

    private static void go() {
        if(n-- > 0) {
            System.out.println(sc.nextInt());
            go();
        }
    }
}
