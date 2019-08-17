package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.util.Scanner;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = sc.nextInt();
        }
        check(inputArray);
    }

    public static void check(int[] inputArray) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int position = 0;

        for (int goal : inputArray) {
            if (goal > position) {
                while (goal > position) {
                    stack.push(++position);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() != goal) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }

        System.out.println(sb);
    }
}