package codeup.기초100제;

import java.util.Scanner;

public class Q1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("[.]");

        int year = Integer.parseInt(input[0]);
        int month = Integer.parseInt(input[1]);
        int day = Integer.parseInt(input[2]);

        System.out.printf("%04d.%02d.%02d",year, month, day);
    }
}
