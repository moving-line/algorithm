/*
문제 설명
2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.

제한 조건
행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
곱할 수 있는 배열만 주어집니다.
 */

package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 행렬의곱셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}}))
                .isEqualTo(new int[][]{{15, 15}, {15, 15}, {15, 15}});

        assertThat(solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}))
                .isEqualTo(new int[][]{{22, 22, 11}, {36, 28, 18}, {29, 20, 14}});
    }
}
