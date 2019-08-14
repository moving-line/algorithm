package baekjoon.codePlus.기초1.ch1_알고리즘시작;

import java.util.Arrays;
import java.util.Scanner;

public class Q10953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        sc.nextLine();
        for (int i = 0; i < T; i++) {
            System.out.println(Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).sum());
        }
    }
}
