/*
문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */

package baekjoon.step11_스택사용하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q10828 {
    // 링크드로 스택 구현해보기
//    private static List<Integer> stack;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        stack = new LinkedList<>();
//        for (int i = 0; i < N; i++) process(br.readLine());
//    }
//
//    private static void process(String input) {
//        if (input.startsWith("push")) {
//            push(Integer.parseInt(input.split(" ")[1]));
//        }
//        if (input.equals("pop")) {
//            pop();
//        }
//        if (input.equals("size")) {
//            size();
//        }
//        if (input.equals("empty")) {
//            empty();
//        }
//        if (input.equals("top")) {
//            top();
//        }
//    }
//
//    private static void top() {
//        if (stack.size() == 0) System.out.println(-1);
//        else System.out.println(stack.get(stack.size() - 1));
//    }
//
//    private static void empty() {
//        if (stack.size() == 0) System.out.println(1);
//        else System.out.println(0);
//    }
//
//    private static void size() {
//        System.out.println(stack.size());
//    }
//
//    private static void pop() {
//        if (stack.size() == 0) System.out.println(-1);
//        else {
//            System.out.println(stack.get(stack.size() - 1));
//            stack.remove(stack.size() - 1);
//        }
//    }
//
//    private static void push(int x) {
//        stack.add(x);
//    }

    // 걍 스택 쓰기
    private static Stack stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stack = new Stack();
        for (int i = 0; i < N; i++) process(br.readLine());
    }

    private static void process(String input) {
        if (input.startsWith("push")) {
            stack.push(Integer.parseInt(input.split(" ")[1]));
        }
        if (input.equals("pop")) {
            if(stack.isEmpty()) System.out.println(-1);
            else System.out.println(stack.pop());
        }
        if (input.equals("size")) {
            System.out.println(stack.size());
        }
        if (input.equals("empty")) {
            if (stack.isEmpty()) System.out.println(1);
            else System.out.println(0);
        }
        if (input.equals("top")) {
            if(stack.isEmpty()) System.out.println(-1);
            else System.out.println(stack.peek());
        }
    }
}