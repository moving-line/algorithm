/*
문제 설명
자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

제한사항
N의 범위 : 100,000,000 이하의 자연수
 */

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 자릿수더하기 {
    public int solution(int n) {
        // 첫번째 풀이
        int answer = 0;

        while(n != 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;

//        두번째 풀이
//        int answer = 0;
//        for (int i = n; i != 0; i /= 10) answer += i % 10;
//
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(123)).isEqualTo(6);
        assertThat(solution(987)).isEqualTo(24);
    }
}
