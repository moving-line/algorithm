/*
문제
여행을 떠난 세준이는 지도를 하나 구하였다. 이 지도는 아래 그림과 같이 직사각형 모양이며 여러 칸으로 나뉘어져 있다.
한 칸은 한 지점을 나타내는데 각 칸에는 그 지점의 높이가 쓰여 있으며, 각 지점 사이의 이동은 지도에서 상하좌우 이웃한 곳끼리만 가능하다.

[지도 생략]

현재 제일 왼쪽 위 칸이 나타내는 지점에 있는 세준이는 제일 오른쪽 아래 칸이 나타내는 지점으로 가려고 한다.
그런데 가능한 힘을 적게 들이고 싶어 항상 높이가 더 낮은 지점으로만 이동하여 목표 지점까지 가고자 한다.
위와 같은 지도에서는 다음과 같은 세 가지 경로가 가능하다.

[지도 생략]
[지도 생략]
[지도 생략]

지도가 주어질 때 이와 같이 제일 왼쪽 위 지점에서 출발하여 제일 오른쪽 아래 지점까지 항상 내리막길로만 이동하는 경로의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 지도의 세로의 크기 M과 가로의 크기 N이 빈칸을 사이에 두고 주어진다.
이어 다음 M개 줄에 걸쳐 한 줄에 N개씩 위에서부터 차례로 각 지점의 높이가 빈 칸을 사이에 두고 주어진다.
M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수이다.

출력
첫째 줄에 이동 가능한 경로의 수 H를 출력한다. 모든 입력에 대하여 H는 10억 이하의 음이 아닌 정수이다.
 */

package baekjoon.step16_동적계획법기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1520 {
    static int M;
    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            String[] heights = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(heights[j]);
                dp[i][j] = -1;
            }
        }

        System.out.println(getPath(0, 0));
    }

    private static int getPath(int i, int j) {
        if (i == M - 1 && j == N - 1) return 1;
        if (dp[i][j] == -1) {
            dp[i][j] = 0;
            if (j < N - 1 && map[i][j] > map[i][j + 1]) dp[i][j] += getPath(i, j + 1);
            if (i < M - 1 && map[i][j] > map[i + 1][j]) dp[i][j] += getPath(i + 1, j);
            if (j > 0 && map[i][j] > map[i][j - 1]) dp[i][j] += getPath(i, j - 1);
            if (i > 0 && map[i][j] > map[i - 1][j]) dp[i][j] += getPath(i - 1, j);
        }

        return dp[i][j];
    }
}