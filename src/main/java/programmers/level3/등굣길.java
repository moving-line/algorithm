/*
계속되는 폭우로 일부 지역이 물에 잠겼습니다. 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다.
집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.

아래 그림은 m = 4, n = 3 인 경우입니다.

[그림 생략]

가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.

격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어질 때,
학교에서 집까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.

제한사항
격자의 크기 M, N은 1 이상 100 이하인 자연수입니다.
물에 잠긴 지역은 0개 이상 10개 이하입니다.
집과 학교는 물에 잠기지 않았습니다.

 */

package programmers.level3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int dp[][] = new int[m + 1][n + 1];

        dp[1][1] = 1;

        for (int[] p : puddles) {
            dp[p[0]][p[1]] = -1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (dp[i][j] == -1) dp[i][j] = 0;
                else {
                    if (i == 1) dp[i][j] += dp[i][j - 1];
                    else dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    @Test
    public void test() {
        assertThat(solution(4, 3, new int[][]{{2, 2}})).isEqualTo(4);
    }
}
