/*
문제
45656이란 수를 보자.
이 수는 인접한 모든 자리수의 차이가 1이 난다. 이런 수를 계단 수라고 한다.
세준이는 수의 길이가 N인 계단 수가 몇 개 있는지 궁금해졌다.
N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
 */

package baekjoon.step16_동적계획법기초;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];
        for (int i = 1; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                dp[i][j] %= 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
            sum %= 1000000000;
        }

        System.out.println(sum);
    }
}
