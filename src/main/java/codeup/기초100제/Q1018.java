package codeup.기초100제;

import java.util.Scanner;

public class Q1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(":");

        String hour = input[0];
        String minute = input[1];

        System.out.printf("%s:%s", hour, minute);

//        System.out.println(sc.nextLine());
    }
}
