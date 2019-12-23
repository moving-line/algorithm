package baekjoon.codePlus.기초2.ch1_브루트포스;

import java.util.Scanner;

public class Q1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;

        for (int start = 1, len = 1; start <= N; start *= 10, len++) {
            int end = start * 10 - 1;
            if(end > N) {
                end = N;
            }
            sum += (end - start + 1) * len;
        }
        System.out.println(sum);
    }

    // 무식한 방법
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int temp = 1;
            int num = i;
            while(num >= 10) {
                num = num / 10;
                temp += 1;
            }
            sum += temp;
        }
        System.out.println(sum);
    }
}
