/*
문제 설명
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다.
문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

제한 조건
공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.
 */

package programmers.level1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 시저암호 {
    public String solution(String s, int n) {
        //첫번째 풀이
        char[] array = s.toCharArray();
        StringBuilder sb =  new StringBuilder();

        for (char c : array) {
            if (c == 32) {
                sb.append(" ");
                continue;
            }
            if (c < 97) {
                if (c + n > 90) sb.append((char)(c + n - 26));
                else sb.append((char)(c + n));
            } else {
                if (c + n > 122) sb.append((char)(c + n - 26));
                else sb.append((char)(c + n));
            }
        }

        return sb.toString();

        // 두번째 풀이
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (Character.isLowerCase(c)) {
//                c = (Character.isLowerCase(c + n)) ? (char) (c + n) : (char) (c + n - 26);
//            } else if (Character.isUpperCase(c)) {
//                c = (Character.isUpperCase(c + n)) ? (char) (c + n) : (char) (c + n - 26);
//            }
//            sb.append(c);
//        }
//        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(solution("AB", 1)).isEqualTo("BC");
        assertThat(solution("z", 1)).isEqualTo("a");
        assertThat(solution("a B z", 4)).isEqualTo("e F d");
    }
}
