package codeup.기초100제;

import java.util.Scanner;

public class Q1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt(); // 세로
        int w = sc.nextInt(); // 가로
        int n = sc.nextInt(); // 막대개수
        int[][] tiles = new int[h][w];

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(); // 막대길이
            int d = sc.nextInt(); // 방향
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = 0; j < n; j++) {
                if (d == 0) { // 가로막대
                    for (int k = 0; k < l; k++) {
                        tiles[x - 1][y - 1 + k] = 1;
                    }
                } else { // 세로막대
                    for (int k = 0; k < l; k++) {
                        tiles[x - 1 + k][y - 1] = 1;
                    }
                }
            }
        }

        for (int[] tile : tiles) {
            for (int t : tile) {
                System.out.printf("%d ", t);
            }
            System.out.println();
        }
    }
}