package codeup.기초100제;

import java.util.Scanner;

public class Q1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char alphabet = sc.next().charAt(0);
        char c = 'a';
        do {
            System.out.print(c++ + " ");
        } while(c <= alphabet);
    }
}
