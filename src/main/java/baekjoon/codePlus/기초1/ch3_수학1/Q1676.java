package baekjoon.codePlus.기초1.ch3_수학1;

import java.util.Scanner;

public class Q1676 {

    //
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i = 5; i <= n; i *= 5) {
            ans += n / i;
        }
        System.out.println(ans);

        // 내 풀이
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//
//        int num5 = 0;
//        for (int i = 1; i <= N; i++) {
//            int target = i;
//
//            while (target % 5 == 0) {
//                target /= 5;
//                num5++;
//            }
//        }
//
//        System.out.println(num5);
    }
}