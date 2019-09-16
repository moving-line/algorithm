package baekjoon.codePlus.기초1.ch2_자료구조1.참고;

import java.util.Arrays;
import java.util.Scanner;

public class Q10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        int[] count = new int[26];
        Arrays.fill(count, -1);

        for (int i = 0; i < S.length(); i++) {
            int a = S.charAt(i) - 97;
            if(count[a] == -1) {
                count[a] = i;
            }
        }

        for (int c : count) {
            System.out.print(c + " ");
        }
    }
}
