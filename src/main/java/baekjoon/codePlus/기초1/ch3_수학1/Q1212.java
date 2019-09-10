package baekjoon.codePlus.기초1.ch3_수학1;

import java.util.Scanner;

public class Q1212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String[] eight = {"000", "001", "010", "011", "100", "101", "110", "111"};
        boolean start = true;

        // 0이 주어졌을 경우 예외처
        if (s.length() == 1 && s.charAt(0) == '0') {
            System.out.print(0);
        }

        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0'; // 현재 주어진 8진수

            if (start && n < 4) { // 4 미만이면서 첫번째 타자일 경우(1로 시작하는 것 떄문에)
                if (n == 0) {
                    continue;
                } else if (n == 1) {
                    System.out.print("1");
                } else if (n == 2) {
                    System.out.print("10");
                } else if (n == 3) {
                    System.out.print("11");
                }
                start = false;
            } else { // 4보다 크거나 첫번째 타자가 아니라서, 딱히 앞에 0에 대한 계산 필요없는경우
                System.out.print(eight[n]);
                start = false;
            }
        }
        System.out.println();
    }
}
