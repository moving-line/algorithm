package baekjoon.codePlus.기초1.ch2_자료구조1.참고;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        List<String> suffix = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            suffix.add(S.substring(i));
        }

        suffix.stream().sorted().forEach(System.out::println);
    }
}