package baekjoon.codePlus.기초1.ch2_자료구조1.참고;

import java.util.Scanner;
import java.util.Stack;

public class Q1935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        char[] postfixNotation = sc.nextLine().toCharArray();
        double[] operands = new double[N];
        for (int i = 0; i < N; i++) {
            operands[i] = sc.nextDouble();
        }

        Stack<Double> stack = new Stack<>();
        for (char c : postfixNotation) {
            if (c == '*') {
                stack.push(stack.pop() * stack.pop());
            } else if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '/') {
                double down = stack.pop();
                double up = stack.pop();
                stack.push(up / down);
            } else if (c == '-') {
                stack.push(-stack.pop() + stack.pop());
            } else {
                stack.push(operands[c - 65]);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
