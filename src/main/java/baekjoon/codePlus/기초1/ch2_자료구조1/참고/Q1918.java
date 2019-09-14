package baekjoon.codePlus.기초1.ch2_자료구조1.참고;

import java.util.Scanner;
import java.util.Stack;

public class Q1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> operator = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                result.append(c);
            } else if (c == '(') {
                operator.push(c);
            } else if (c == ')') {
                while (!operator.isEmpty()) {
                    char op = operator.pop();
                    if (op == '(') {
                        break;
                    }
                    result.append(op);
                }
            } else {
                while (!operator.isEmpty() && calculate(operator.peek()) >= calculate(c)) {
                    result.append(operator.pop());
                }
                operator.push(c);
            }
        }

        while (!operator.isEmpty()) {
            result.append(operator.pop());
        }
        System.out.println(result);
    }

    private static int calculate(char c) {
        if (c == '(') {
            return 0;
        }
        return (c == '+' || c == '-') ? 1 : 2;
    }
}