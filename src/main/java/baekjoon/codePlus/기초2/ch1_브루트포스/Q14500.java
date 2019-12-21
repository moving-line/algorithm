package baekjoon.codePlus.기초2.ch1_브루트포스;

import java.util.Scanner;

public class Q14500 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // ㅁㅁㅁㅁ
                if (j + 3 < M) {
                    int temp = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ
                // ㅁ
                // ㅁ
                // ㅁ
                if (i + 3 < N) {
                    int temp = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ ㅁ
                // ㅁ ㅁ
                if (i + 1 < N && j + 1 < M) {
                    int temp = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ ㅁ ㅁ
                //   ㅁ
                if(i + 1 < N && j + 2 < M) {
                    int temp = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1];
                    if (temp > max) {
                        max = temp;
                    }
                }

                //   ㅁ
                // ㅁ ㅁ ㅁ
                if(i + 1 < N && j + 2 < M) {
                    int temp = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ
                // ㅁ ㅁ
                // ㅁ
                if(i + 2 < N && j + 1 < M) {
                    int now = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j];
                    if (now > max) {
                        max = now;
                    }
                }

                //   ㅁ
                // ㅁ ㅁ
                //   ㅁ
                if(i + 2 < N && j + 1 < M) {
                    int temp = paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ
                // ㅁ
                // ㅁ ㅁ
                if(i + 2 < N && j + 1 < M) {
                    int temp = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
                    if (temp > max) {
                        max = temp;
                    }
                }

                //    ㅁ
                //    ㅁ
                // ㅁ ㅁ
                if(i + 2 < N && j + 1 < M) {
                    int temp = paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j] + paper[i + 2][j + 1];
                    if (temp > max) {
                        max = temp;
                    }
                }

                //      ㅁ
                // ㅁ ㅁ ㅁ
                if(i + 1 < N && j + 2 < M) {
                    int temp = paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ
                // ㅁ ㅁ ㅁ
                if(i + 1 < N && j + 2 < M) {
                    int temp = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ ㅁ
                // ㅁ
                // ㅁ
                if(i + 2 < N && j + 1 < M) {
                    int temp = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 2][j];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ ㅁ
                //    ㅁ
                //    ㅁ
                if(i + 2 < N && j + 1 < M) {
                    int temp = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ ㅁ ㅁ
                // ㅁ
                if(i + 1 < N && j + 2 < M) {
                    int temp = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ ㅁ ㅁ
                //      ㅁ
                if(i + 1 < N && j + 2 < M) {
                    int temp = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 2];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ
                // ㅁ ㅁ
                //    ㅁ
                if(i + 2 < N && j + 1 < M) {
                    int temp = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
                    if (temp > max) {
                        max = temp;
                    }
                }

                //    ㅁ
                // ㅁ ㅁ
                // ㅁ
                if(i + 2 < N && j + 1 < M) {
                    int temp = paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j];
                    if (temp > max) {
                        max = temp;
                    }
                }

                //    ㅁ ㅁ
                // ㅁ ㅁ
                if(i + 1 < N && j + 2 < M) {
                    int temp = paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1];
                    if (temp > max) {
                        max = temp;
                    }
                }

                // ㅁ ㅁ
                //    ㅁ ㅁ
                if(i + 1 < N && j + 2 < M) {
                    int temp = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
