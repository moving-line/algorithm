package baekjoon.codePlus.기초1.ch2_자료구조1;

import java.util.Scanner;

public class Q10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dq = new int[N];
        int end = 0;

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String order = sc.nextLine();

            if (order.startsWith("push")) {
                int element = Integer.parseInt(order.split(" ")[1]);

                // push_front
                if (order.contains("front")) {
                    for (int j = end; j > 0; j--) {
                        dq[j] = dq[j - 1];
                    }
                    dq[0] = element;

                } else { // push_back
                    dq[end] = element;
                }
                end++;

            } else if (order.startsWith("pop")) {

                // pop_front
                if (order.contains("front")) {
                    if (end <= 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq[0]);
                        for (int j = 1; j < end; j++) {
                            dq[j - 1] = dq[j];
                        }
                        dq[end - 1] = 0;
                        end--;
                    }

                } else { // pop_back
                    if (end <= 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(dq[end - 1]);
                        dq[end - 1] = 0;
                        end--;
                    }
                }

            } else if (order.startsWith("size")) {
                System.out.println(end);

            } else if (order.startsWith("empty")) {
                if (end <= 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }

            } else if (order.startsWith("front")) {
                if (end <= 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq[0]);
                }

            } else if (order.startsWith("back")) {
                if (end <= 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq[end - 1]);
                }
            }
        }
    }
}