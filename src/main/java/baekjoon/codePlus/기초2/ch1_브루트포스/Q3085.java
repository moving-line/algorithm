package baekjoon.codePlus.기초2.ch1_브루트포스;

import java.util.Scanner;

public class Q3085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] board = new char[N][N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            char[] chars = sc.nextLine().toCharArray();
            System.arraycopy(chars, 0, board[i], 0, N);
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // check east
                if (j + 1 < N) {
                    // swap
                    char temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;

                    int max = check(board);
                    if(result < max) {
                        result = max;
                    }

                    // recovery
                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }

                // check south
                if (i + 1 < N) {
                    // swap
                    char temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;

                    int max = check(board);
                    if(result < max) {
                        result = max;
                    }

                    // recovery
                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                }
            }
        }

        System.out.println(result);
    }

    private static int check(char[][] board) {
        int length = board.length;
        int max = 1;
        for (int i = 0; i < length; i++) {

            // check horizontal
            int count = 1;
            for (int j = 1; j < length; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count += 1;
                } else {
                    count = 1;
                }
                if (max < count) {
                    max = count;
                }
            }

            // check vertical
            count = 1;
            for (int j = 1; j < length; j++) {
                if (board[j][i] == board[j - 1][i]) {
                    count += 1;
                } else {
                    count = 1;
                }
                if (max < count) {
                    max = count;
                }
            }
        }
        return max;
    }
}
