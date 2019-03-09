/*
문제 설명
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
예를 들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

제한 조건
arr은 길이 1 이상인 배열입니다.
인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 제일작은수더하기 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};

        int num = arr[0];
        for (int i = 1; i < arr.length; i++) if(arr[i] < num) num = arr[i];

        List<Integer> list = new ArrayList<>();
        for (int i : arr) if(i != num) list.add(i);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);

        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(new int[] {4, 3, 2, 1})).isEqualTo(new int[] {4, 3, 2});
        assertThat(solution(new int[] {10})).isEqualTo(new int[] {-1});
        assertThat(solution(new int[] {7, 9 , 1, 13, 4})).isEqualTo(new int[] {7, 9, 13, 4});
    }
}
