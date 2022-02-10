/*
문제 설명
문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.

제한 조건
s의 길이는 1 이상 5이하입니다.
s의 맨앞에는 부호(+, -)가 올 수 있습니다.
s는 부호와 숫자로만 이루어져있습니다.
s는 0으로 시작하지 않습니다.
 */
package programmers.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 문자열을정수로바꾸기 {
    public int solution(String s) {
        return Integer.parseInt(s);
    }

    @Test
    public void test() {
        assertThat(solution("+1234")).isEqualTo(1234);
        assertThat(solution("1234")).isEqualTo(1234);
        assertThat(solution("-1234")).isEqualTo(-1234);
    }
}