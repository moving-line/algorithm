/*
문제 설명
정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.

제한 조건
num은 int 범위의 정수입니다.
0은 짝수입니다.
*/
package programmers.level1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 짝수와홀수 {
    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    @Test
    public void test() {
        assertThat(solution(3)).isEqualTo("Odd");
        assertThat(solution(4)).isEqualTo("Even");
    }
}