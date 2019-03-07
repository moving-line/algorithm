/*
문제 설명
임의의 정수 n에 대해, n이 어떤 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

제한 사항
n은 1이상, 50000000000000 이하인 정수입니다.
 */

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 정수제곱근판별 {
    public long solution(long n) {
        return Math.sqrt(n) - (int)Math.sqrt(n) == 0 ? (long)Math.pow(Math.sqrt(n) + 1, 2) : -1;
    }

    @Test
    public void test() {
        assertThat(solution(121)).isEqualTo(144);
        assertThat(solution(3)).isEqualTo(-1);
    }
}
