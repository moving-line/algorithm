package codeup.기초100제;

import java.util.Scanner;

public class Q1066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = {a, b, c};

        for (int i : arr) {
            if (i % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }
}
