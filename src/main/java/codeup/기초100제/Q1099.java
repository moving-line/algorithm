package codeup.기초100제;

import java.util.Scanner;

public class Q1099 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] maze = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        int i = 1;
        int j = 1;
        while (i != 10 || j != 10) {
            if (maze[i][j] == 2) { // 도착 시
                maze[i][j] = 9;
                break;
            }

            if (maze[i][j] == 0) { // 현재 채우기
                maze[i][j] = 9;
            } else if (j + 1 < 10 && (maze[i][j + 1] == 0 || maze[i][j + 1] == 2)){ // 오른쪽 탐색
                j++;
            } else if (i + 1 < 10 && (maze[i + 1][j] == 0 || maze[i + 1][j] == 2)) { // 왼쪽 탐색
                i++;
            } else { // 갈곳이 없다
                break;
            }
        }

        for (int[] m : maze) {
            for (int n : m) {
                System.out.printf("%d ", n);
            }
            System.out.println();
        }
    }
}
