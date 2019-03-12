/*
문제 설명
문자열 s의 길이가 4혹은 6이고, 숫자로만 구성되있는지 확인해주는 함수, solution을 완성하세요.
예를들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
 */
package programmers.level1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 문자열다루기기본 {
    public boolean solution(String s) {

        //첫번째 풀이
        if (s.length() == 4 || s.length() == 6) {
            int sum = 0;

            for (int i = 0; i < s.length(); i++) {
                if (isNumber(s.substring(i, i + 1))) {
                    sum++;
                }
            }

            return s.length() == sum;
        }

        return false;

//        두번째풀이
//        if (s.length() == 4 || s.length() == 6) {
//            try {
//                Integer.parseInt(s);
//                return true;
//            } catch (Exception e) {
//                return false;
//            }
//        }
//        return false;

//        세번째풀이
//        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
//        return false;

//        네번째풀이
//        if (s.length() != 4 && s.length() != 6) return false;
//        for (int i = 0; i < s.length(); ++i) {
//            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
//        }
//        return true;
    }

    public boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Test
    public void test() {
        assertThat(solution("a234")).isEqualTo(false);
        assertThat(solution("1234")).isEqualTo(true);
        assertThat(solution("123456")).isEqualTo(true);
        assertThat(solution("123a56")).isEqualTo(false);

    }
}
