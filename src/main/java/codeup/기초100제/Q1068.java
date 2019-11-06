package codeup.기초100제;

import java.util.Scanner;

public class Q1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        String rank = "D";
        if(score >= 90) {
            rank = "A";
        } else if(score >= 70) {
            rank = "B";
        } else if(score >= 40) {
            rank = "C";
        }

        System.out.println(rank);
    }
}
