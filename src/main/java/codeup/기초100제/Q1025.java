package codeup.기초100제;

import java.util.Scanner;

public class Q1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");
        for (int i = 0; i < input.length; i++) {
            System.out.printf("[%d]\n",Integer.parseInt(input[i]) * (int)Math.pow(10, input.length - 1 - i));
        }
    }
}
