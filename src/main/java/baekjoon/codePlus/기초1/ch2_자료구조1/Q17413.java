package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.io.*;
import java.util.*;

public class Q17413 {
    // 백준 풀이
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        char[] input = br.readLine().toCharArray();
        boolean tag = false;

        for (char c : input) {
            if (c == '<') { // 태그 시작
                print();
                tag = true;
                bw.write(c);

            } else if (c == '>') { // 태그 종료
                tag = false;
                bw.write(c);

            } else if (tag) { // 태그 내에 있을 경우
                bw.write(c);

            } else {
                if (c == ' ') {
                    print();
                    bw.write(c);
                } else {
                    stack.push(c);
                }
            }
        }

        print();
        bw.write("\n");
        bw.flush();
    }

    private static void print() throws IOException {
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }

    // 기존 내 풀이
//    private static Stack<Character> stack = new Stack<>();
//    private static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        char[] chars = sc.nextLine().toCharArray();
//        List<Character> list = new LinkedList<>();
//
//        for (char c : chars) {
//
//            if (c == '<') { // 괄호 시작
//                if (!stack.isEmpty()) {
//                    int size = stack.size();
//                    for (int j = 0; j < size; j++) {
//                        sb.append(stack.pop());
//                    }
//                }
//                list.add('<');
//                sb.append('<');
//
//            } else if (c == '>') { // 괄호 종료
//                list = new LinkedList<>();
//                sb.append(c);
//
//            } else if (list.contains('<')) {  // 괄호 내용
//                sb.append(c);
//
//            } else if (c == 32) {  // 빈칸 발견시
//                int size = stack.size();
//                for (int j = 0; j < size; j++) {
//                    sb.append(stack.pop());
//                }
//                sb.append(" ");
//
//            } else { // 바꾸기할 글자는 스택에 쌓아두기
//                stack.push(c);
//            }
//        }
//
//        // 빈칸을 만나지 못한 나머지들 방출
//        print();
//        System.out.println(sb.toString());
//    }
//
//    private static void print() {
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//    }
}
