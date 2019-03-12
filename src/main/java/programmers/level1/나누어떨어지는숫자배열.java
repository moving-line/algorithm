/*
문제 설명
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.
 */
package programmers.level1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        // 첫번째 풀이
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            if (a % divisor == 0) list.add(a);
        }

        if (list.size() == 0) return new int[]{-1};

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;

//        두번째 풀이 (개선함)
//        int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
//        if(answer.length == 0) answer = new int[] {-1};
//
//        return answer;

//        세번째 풀이
//        int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
//        return answer.length != 0 ? answer : new int[] {-1};

//        네번째 풀이
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int a : arr) {
//            if (a % divisor == 0) list.add(a);
//        }
//        if (list.size() == 0) return new int[] {-1};
//
//        return list.stream().mapToInt(i -> i).sorted().toArray();
    }

    @Test
    public void test() {
        assertThat(solution(new int[] {5, 9, 7, 10}, 5)).isEqualTo(new int[] {5, 10});
        assertThat(solution(new int[] {2, 36, 1, 3}, 1)).isEqualTo(new int[] {1, 2, 3, 36});
        assertThat(solution(new int[] {3, 2, 6}, 10)).isEqualTo(new int[] {-1});
    }
}
