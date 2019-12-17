package baekjoon.codePlus.기초2.ch1_브루트포스;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dwarf = new int[9];
        int total = 0;
        for (int i = 0; i < 9; i++) {
            dwarf[i] = sc.nextInt();
            total += dwarf[i];
        }

        for (int i = 0; i < dwarf.length - 1; i++) {
            for (int j = i + 1; j < dwarf.length; j++) {
                if(total - dwarf[i] - dwarf[j] == 100) {
                    dwarf[i] = dwarf[j] = 0;
                    Arrays.stream(dwarf)
                            .filter(d -> d > 0)
                            .sorted()
                            .forEach(System.out::println);
                    return;
                }
            }
        }
    }
}
