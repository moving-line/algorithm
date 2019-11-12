package codeup.기초100제;

import java.util.Scanner;

public class Q1079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        while(!input.equals("q")) {
            System.out.println(input);
            input = sc.next();
        }
        System.out.println(input);
    }
}
