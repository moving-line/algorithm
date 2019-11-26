package codeup.기초100제;

import java.util.Scanner;

public class Q1095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = 23;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input < min) {
                min = input;
            }
        }
        System.out.println(min);
    }
}
