/*
문제 설명
프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때,
전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

제한 조건
s는 길이 4 이상, 20이하인 문자열입니다.
 */
package programmers.level1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        //첫번째 풀이
        int size = phone_number.length();
        String answer = frontNumber(size) + phone_number.substring(size - 4);

        return answer;

//        두번째 풀이
//        StringBuilder answer = new StringBuilder();
//        for (int i = 0; i < phone_number.length() - 4; i++) answer.append("*");
//        answer.append(phone_number.substring(phone_number.length() - 4));
//
//        return answer.toString();

    }

    public String frontNumber(int size) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size - 4; i++) {
            sb.append("*");
        }

        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(solution("01033334444")).isEqualTo("*******4444");
        assertThat(solution("027778888")).isEqualTo("*****8888");
    }
}
