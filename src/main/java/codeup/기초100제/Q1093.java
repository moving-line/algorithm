package codeup.기초100제;

import java.util.Scanner;

public class Q1093 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] attendance = new int[23];

        for (int i = 0; i < n; i++) {
            attendance[sc.nextInt() - 1]++;
        }
        for (int i : attendance) {
            System.out.print(i + " ");
        }
    }
}