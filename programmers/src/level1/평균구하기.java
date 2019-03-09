/*
문제 설명
정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

제한조건
arr은 길이 1 이상, 100 이하인 배열입니다.
arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
*/

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 평균구하기 {
    public double solution(int[] arr) {
        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum/arr.length;
    }

    @Test
    public void test() {
        assertThat(solution(new int[] {1, 2, 3, 4})).isEqualTo(2.5);
        assertThat(solution(new int[] {5, 5})).isEqualTo(5);
    }
}