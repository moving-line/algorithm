package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.util.Scanner;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();

        // 백준풀이
        for (int i = 0; i < testCase; i++) {
            System.out.println(check(sc.nextLine()));
        }
    }

    private static String check(String str) {
        int cnt = 0;

        for (int j = 0; j < str.length(); j++) {
            if (str.charAt(j) == '(') {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt < 0) {
                return "NO";
            }
        }

        if (cnt == 0) {
            return "YES";
        } else {
            return "NO";
        }


        // 기존 내풀이2
//        outer : for (int i = 0; i < testCase; i++) {
//            Stack<Character> stack = new Stack<>();
//            char[] input = sc.nextLine().toCharArray();
//
//            for (char c : input) {
//                if (c == '(') {
//                    stack.push('(');
//                } else {
//                    if (!stack.isEmpty()) {
//                        stack.pop();
//                    } else {
//                        System.out.println("NO");
//                        continue outer;
//                    }
//                }
//            }
//
//            if(!stack.isEmpty()) {
//                System.out.println("NO");
//            } else {
//                System.out.println("YES");
//            }
//        }

        // 기존 내풀이1
//        for (int i = 0; i < testNumber; i++) {
//            stack = new Stack<>();
//            int sum = 0;
//
//            String[] input = sc.nextLine().split("");
//            for (String s : input) {
//                stack.push(s);
//            }
//
//            if(stack.peek().equals("(")) {
//                System.out.println("NO");
//                continue;
//            }
//
//            while (!stack.isEmpty() && sum >= 0) {
//                String p = stack.pop();
//
//                if ((p.equals(")"))) {
//                    sum++;
//                } else {
//                    sum--;
//                }
//            }
//
//            if(sum != 0) {
//                System.out.println("NO");
//            } else {
//                System.out.println("YES");
//            }
//        }
    }
}

