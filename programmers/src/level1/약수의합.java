/*
문제 설명
자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

제한사항
n은 0 이상 3000이하인 자연수입니다.
*/

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 약수의합 {
    public int solution(int n) {
        int sum = n;

        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) sum += i;
        }

        return sum;
    }

    @Test
    public void test() {
        assertThat(solution(12)).isEqualTo(28);
        assertThat(solution(5)).isEqualTo(6);
        assertThat(solution(1)).isEqualTo(1);
    }
}