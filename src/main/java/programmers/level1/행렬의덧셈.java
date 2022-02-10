/*
문제 설명
행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

제한 조건
행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
 */
package programmers.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 행렬의덧셈 {
    public int[][] solution(int[][] a, int[][] b) {
        // 첫번째 풀이
        int[][] answer = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                answer[i][j] = a[i][j] + b[i][j];
            }
        }

        return answer;

//        두번째 풀이
//        int row = Math.max(a.length, b.length);
//        int col = Math.max(a[0].length, b[0].length);
//
//        int[][] answer = new int[row][col];
//
//        for(int i = 0; i < row ; i++){
//            for(int j = 0; j < col; j++){
//                answer[i][j] = a[i][j] + b[i][j];
//            }
//        }
//
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(new int[][] {new int[] {1, 2}, new int[] {2, 3}},
                new int[][] {new int[] {3, 4}, new int[] {5, 6}})).
                isEqualTo(new int[][] {new int[] {4, 6}, new int[] {7, 9}});

        assertThat(solution(new int[][] {new int[] {1}, new int[] {2}},
                new int[][] {new int[] {3}, new int[] {4}})).
                isEqualTo(new int[][] {new int[] {4}, new int[] {6}});
    }
}
