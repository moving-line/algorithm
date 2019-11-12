package codeup.기초100제;

import java.util.Scanner;

public class Q1078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sumOfEven = 0;
        for (int i = 0; i <= n; i += 2) {
            sumOfEven += i;
        }
        System.out.println(sumOfEven);
    }
}
