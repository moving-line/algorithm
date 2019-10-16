package codeup.기초100제;

import java.util.Scanner;

public class Q1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("[.]");
        System.out.printf("%02d-%02d-%04d",
                Integer.parseInt(input[2]),
                Integer.parseInt(input[1]),
                Integer.parseInt(input[0]));
    }
}
