package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.io.*;
import java.util.Stack;

public class Q1406 {
    // O(N + M)
    private static Stack<Character> left = new Stack<>();
    private static Stack<Character> right = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < word.length(); i++) {
            left.push(word.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            edit(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : left) {
            sb.append(c);
        }
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void edit(String order) {
        if (order.equals("L")) {
            if (!left.isEmpty()) {
                right.push(left.pop());
            }
        } else if (order.equals("D")) {
            if (!right.isEmpty()) {
                left.push(right.pop());
            }
        } else if (order.equals("B")) {
            if (!left.isEmpty()) {
                left.pop();
            }
        } else {
            left.push(order.charAt(2));
        }
    }

    // 기존 풀이 ... 시간초과 -> O(N^2)
//    private static StringBuffer sb = new StringBuffer();
//    private static int position;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        sb.append(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//        position = sb.length();
//
//        for (int i = 0; i < M; i++) {
//            edit(br.readLine());
//        }
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//    }
//
//    private static void edit(String order) {
//        if (order.equals("L")) {
//            if (position > 0) {
//                position--;
//            }
//        } else if (order.equals("D")) {
//            if (position < sb.length()) {
//                position++;
//            }
//        } else if (order.equals("B")) {
//            if (position > 0) {
//                sb.delete(position - 1, position);
//                position--;
//            }
//        } else {
//            sb.insert(position, order.split(" ")[1]);
//            position++;
//        }
//    }
}