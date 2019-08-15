package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.util.Scanner;
import java.util.Stack;

public class Q9093 {
    public static void main(String[] args) {
        // 백준 풀이
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            char[] input = (sc.nextLine() + " ").toCharArray();
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for (char c : input) {
                if (c != 32) {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }
            }

            // 이 부분은 전체문자열에 + " " 해주는 아이디어로 제거 가능
//            while (!stack.isEmpty()) {
//                sb.append(stack.pop());
//            }

            System.out.println(sb.toString());
        }


        // 기존 내풀이
//        for (int i = 0; i < T; i++) {
//            String[] input = sc.nextLine().split(" ");
//            Stack<Character> stack = new Stack<>();
//
//            for (int j = input.length - 1; j >= 0; j--) {
//                String s = input[j];
//                char[] charArray = s.toCharArray();
//
//                for (char c : charArray) {
//                    stack.push(c);
//                }
//
//                if(j != 0) stack.push((char) 32);
//            }
//
//            int size = stack.size();
//            for (int j = 0; j < size; j++) {
//                System.out.print(stack.pop());
//            }
//            System.out.println();
//        }
    }
}
