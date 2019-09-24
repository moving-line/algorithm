package baekjoon.codePlus.기초1.ch3_수학1.참고;

import java.util.Scanner;
import java.util.Stack;

public class Q11576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int m = sc.nextInt();

        int number = 0;
        for (int i = 0; i < m; i++) {
            number += (Math.pow(A, (m - 1) - i) * sc.nextInt());
        }

        Stack<Integer> stack = new Stack<>();
        while(number / B != 0) {
            stack.push(number % B);
            number /= B;
        }
        if(number != 0) {
            stack.push(number % B);
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

    //      백준 풀이
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int n = sc.nextInt();
//
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            ans = ans * a + x;
//        }
//
//        convert(ans, b);
//        System.out.println();
//    }
//
//    public static void convert(int num, int base) {
//        if (num == 0) {
//            return;
//        }
//        convert(num / base, base);
//        System.out.print(num % base + " ");
//    }
}
