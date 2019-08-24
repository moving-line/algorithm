package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.util.Scanner;
import java.util.Stack;

public class Q10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] bars = sc.nextLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < bars.length; i++) {
            if(bars[i] == '(') {
                stack.push(i);
            } else {
                if(stack.peek() == i - 1) { // 바로 닫히면(레이저)
                    stack.pop();
                    sum += stack.size();
                } else {
                    stack.pop();
                    sum += 1;
                }
             }
        }

        System.out.println(sum);
    }
}
