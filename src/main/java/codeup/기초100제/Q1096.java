package codeup.기초100제;

import java.util.Scanner;

public class Q1096 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tiles = new int[19][19];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            tiles[x - 1][y - 1] = 1;
        }

        for (int[] tile : tiles) {
            for (int t : tile) {
                System.out.printf("%d ", t);
            }
            System.out.println();
        }
    }
}
