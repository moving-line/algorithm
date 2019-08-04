/*
문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다.
또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 집 i의 이웃은 집 i-1과 집 i+1이다.
각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때,
모든 집을 칠할 때 드는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다.
둘째 줄부터 N개의 줄에 각 집을 빨강으로 칠할 때, 초록으로 칠할 때, 파랑으로 칠할 때 드는 비용이 주어진다.
비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠할 때 드는 비용의 최솟값을 출력한다.

 */

package baekjoon.step12_동적계획법1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[3][N];
        String[] cost = br.readLine().split(" ");
        costs[0][0] = Integer.parseInt(cost[0]);
        costs[1][0] = Integer.parseInt(cost[1]);
        costs[2][0] = Integer.parseInt(cost[2]);

        for (int i = 1; i < N; i++) {
            cost = br.readLine().split(" ");

            int r = Integer.parseInt(cost[0]);
            int g = Integer.parseInt(cost[1]);
            int b = Integer.parseInt(cost[2]);

            costs[0][i] = r + Math.min(costs[1][i - 1], costs[2][i - 1]);
            costs[1][i] = g + Math.min(costs[0][i - 1], costs[2][i - 1]);
            costs[2][i] = b + Math.min(costs[0][i - 1], costs[1][i - 1]);
        }

        System.out.println(Math.min(costs[0][N - 1], Math.min(costs[1][N - 1], costs[2][N - 1])));
    }
}
