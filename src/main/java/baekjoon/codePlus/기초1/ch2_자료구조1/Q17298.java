package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.io.*;
import java.util.Stack;

public class Q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] NGE = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < N; i++) {

            // 스택이 비어있으면 i 추가
            if (stack.isEmpty()) {
                stack.push(i);
            }

            // 스택에 뭔가 있으면서, A[스택마지막값] < A[i] 일때 NGE[스택마지막값] = A[i]이면..... 반복하여 NGE에 넣기
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                NGE[stack.pop()] = A[i];
            }

            // 스택에 i 추가
            stack.push(i);
        }

        // 남은 놈 -1 처
        while (!stack.empty()) {
            NGE[stack.pop()] = -1;
        }

        // view
        for (int i = 0; i < N; i++) {
            bw.write(NGE[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
