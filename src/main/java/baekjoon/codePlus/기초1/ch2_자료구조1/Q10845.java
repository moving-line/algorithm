package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.util.Scanner;

public class Q10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] q = new int[N];
        int begin = 0, end = 0;

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String order = sc.nextLine();

            if (order.startsWith("push")) {
                q[end++] = Integer.parseInt(order.split(" ")[1]);
            } else if (order.startsWith("pop")) {
                if (begin == end) {
                    System.out.println(-1);
                } else {
                    System.out.println(q[begin++]);
                }
            } else if (order.startsWith("size")) {
                System.out.println(end - begin);
            } else if (order.startsWith("empty")) {
                if (begin == end) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.startsWith("front")) {
                if (begin == end) {
                    System.out.println(-1);
                } else {
                    System.out.println(q[begin]);
                }
            } else if (order.startsWith("back")) {
                if (begin == end) {
                    System.out.println(-1);
                } else {
                    System.out.println(q[end - 1]);
                }
            }
        }
    }
}