package baekjoon.codePlus.기초1.ch3_수학1;

import java.util.Scanner;

public class Q2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int numOfTwo = 0;
        int numOfFive = 0;

        for (long i = 5; i <= n; i *= 5) {
            numOfFive += n / i;
        }
        for (long i = 2; i <= n; i *= 2) {
            numOfTwo += n / i;
        }

        for (long i = 5; i <= m; i *= 5) {
            numOfFive -= m / i;
        }
        for (long i = 2; i <= m; i *= 2) {
            numOfTwo -= m / i;
        }

        for (long i = 5; i <= n - m; i *= 5) {
            numOfFive -= (n - m) / i;
        }
        for (long i = 2; i <= n - m; i *= 2) {
            numOfTwo -= (n - m) / i;
        }

        System.out.println(Math.min(numOfTwo, numOfFive));
    }
}