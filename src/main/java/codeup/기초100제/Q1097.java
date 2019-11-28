package codeup.기초100제;

import java.util.Scanner;

public class Q1097 {
    private static int[][] tiles = new int[19][19];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                tiles[i][j] = sc.nextInt();
            }
        }

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            croessFlip(x, y);
        }

        for (int[] tile : tiles) {
            for (int t : tile) {
                System.out.printf("%d ", t);
            }
            System.out.println();
        }

    }

    private static void croessFlip(int x, int y) {
        for (int i = 0; i < 19; i++) {
            tiles[x - 1][i] = (tiles[x - 1][i] != 0) ? 0 : 1;
            tiles[i][y - 1] = (tiles[i][y - 1] != 0) ? 0 : 1;
        }
    }
}
