package baekjoon.codePlus.기초1.ch3_수학1;

import java.util.Scanner;
import java.util.Stack;

public class Q2089 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        if (N == 0) {
            System.out.println(N);
        }

        while (N != 0) {
            stack.push(Math.abs(N % -2));
            N = (int) Math.ceil((double) N / -2);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
