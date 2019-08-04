package baekjoon.step6_함수;

import java.util.Scanner;

public class Q11729 {
    public static int count = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        move(N, 1, 2, 3);
        System.out.println(sb.insert(0, count + "\n"));
    }

    public static void move(int n, int start, int via, int end) {
        count++;
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
        } else {
            move(n - 1, start, end, via);
            sb.append(start).append(" ").append(end).append("\n");
            move(n - 1, via, start, end);
        }
    }
}