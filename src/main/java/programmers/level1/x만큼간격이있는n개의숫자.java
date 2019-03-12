/*
문제 설명
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

제한 조건
x는 -10000000 이상, 10000000 이하인 정수입니다.
n은 1000 이하인 자연수입니다.
 */
package programmers.level1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class x만큼간격이있는n개의숫자 {
    public long[] solution(int x, int n) {
        //첫번째 풀이
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;

//        두번째 풀이
//        long[] answer = new long[n];
//        for (int i = 0; i < n; i++) answer[i] = (long)(i + 1) * x;
//
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(2, 5)).isEqualTo(new long[] {2, 4, 6, 8, 10});
        assertThat(solution(4, 3)).isEqualTo(new long[] {4, 8, 12});
        assertThat(solution(-4, 2)).isEqualTo(new long[] {-4, -8});
    }
}
