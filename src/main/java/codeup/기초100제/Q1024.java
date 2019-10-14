package codeup.기초100제;

import java.util.Scanner;

public class Q1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            System.out.println("'" + input.charAt(i) + "'");
        }
    }
}
