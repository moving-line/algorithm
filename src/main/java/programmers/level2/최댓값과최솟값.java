/*
문제 설명
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 (최소값) (최대값)형태의 문자열을 반환하는 함수, solution을 완성하세요.
예를들어 s가 1 2 3 4라면 1 4를 리턴하고, -1 -2 -3 -4라면 -4 -1을 리턴하면 됩니다.

제한 조건
s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 */

package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 최댓값과최솟값 {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

//        첫번째 풀이
        int min = arr[0];
        int max = arr[0];

        for (int a : arr) {
            if (a < min) min = a;
            if (a > max) max = a;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();

//         두번째 풀이
//        Arrays.sort(arr);
//        return arr[0] + " " + arr[arr.length - 1];
    }

    @Test
    public void test() {
        assertThat(solution("1 2 3 4")).isEqualTo("1 4");
        assertThat(solution("-1 -2 -3 -4")).isEqualTo("-4 -1");
        assertThat(solution("-1 -1")).isEqualTo("-1 -1");
    }
}
