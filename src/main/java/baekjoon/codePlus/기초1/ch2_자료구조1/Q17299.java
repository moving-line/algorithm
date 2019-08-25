package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.io.*;
import java.util.Stack;

public class Q17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] FA = new int[1000001];
        int[] result = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
            FA[A[i]]++;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            while (!stack.isEmpty() && FA[A[stack.peek()]] < FA[A[i]]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}