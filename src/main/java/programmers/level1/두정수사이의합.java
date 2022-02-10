/*
문제 설명
두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.

제한 조건
a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
a와 b의 대소관계는 정해져있지 않습니다.
 */

package programmers.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 두정수사이의합 {
    public long solution(int a, int b) {
        // 첫번째 풀이
        long sum = 0;

        if (a < b) {
            for (int i = a; i <= b; i++) {
                sum += i;
            }
        } else if(a > b) {
            for (int i = b; i <= a; i++) {
                sum += i;
            }
        } else {
            sum = a;
        }
        return sum;


//        두번째 풀이
//        long sum = 0;
//        for (int i = Math.min(a,b); i <= Math.max(a,b); i++) {
//            sum += i;
//        }
//        return sum;

//        세번째 풀이
//        long sum = 0;
//        for (int i = (a > b ? b : a); i <= (a > b ? a : b); i++) {
//            sum += i;
//        }
//        return sum;
    }

    @Test
    public void test() {
        assertThat(solution(3, 5)).isEqualTo(12);
        assertThat(solution(5, 3)).isEqualTo(12);
        assertThat(solution(3, 3)).isEqualTo(3);
        assertThat(solution(-3, 5)).isEqualTo(9);
    }
}
