package codeup.기초100제;

import java.util.Scanner;

public class Q1092 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if(i % a == 0 && i % b == 0 && i % c == 0) {
                System.out.println(i);
                return;
            }
        }

//        int ab = ((a * b) / gcd(a, b));
//        int result = ((ab * c) / gcd(ab, c));
//
//        System.out.println(result);

    }

//    private static int gcd(int a, int b) {
//        while (b != 0) {
//            int r = a % b;
//            a = b;
//            b = r;
//        }
//
//        return a;
//    }
}
