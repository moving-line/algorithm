/*
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
예를 들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
 */
package programmers.level1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        // 첫번째 풀이
        int[] answer = new int[String.valueOf(n).length()];

        for (int i = 0; n != 0; i++) {
            answer[i] += (n % 10);
            n /= 10;
        }

        return answer;

//        두번째 풀이
//        String number = String.valueOf(n);
//        int[] answer = new int[number.length()];
//
//        for (int i = 0; i <= number.length() - 1; i++) {
//            answer[i] = number.charAt(number.length() - 1 - i) - 48;
//        }
//
//        return answer;

//        세번째 풀이
//        String[] list = new StringBuilder(String.valueOf(n)).reverse().toString().split("");
//        int[] answer = new int[list.length];
//
//        for (int i = 0; i < list.length; i++) {
//            answer[i] = Integer.parseInt(list[i]);
//        }
//
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution(12345)).isEqualTo(new int[] {5, 4, 3, 2, 1});
    }
}
