package codeup.기초100제;

import java.util.Scanner;

public class Q1083 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (is369(i)) {
                System.out.print("X\n");
            } else {
                System.out.print(i + "\n");
            }
        }
    }

    private static boolean is369(int i) {
        char[] arr = String.valueOf(i).toCharArray();
        for (char c : arr) {
            if(c == '3' || c == '6' || c == '9') {
                return true;
            }
        }
        return false;
    }
}
