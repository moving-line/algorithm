/*
문제 설명
문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

제한 사항
문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
 */

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 이상한문자만들기 {
    public String solution(String s) {
        // 첫번째 풀이
        char[] charList = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (char c : charList) {
            if (c == 32) {
                sb.append(" ");
                index = 0;
            } else if (index % 2 == 0) {
                sb.append(String.valueOf(c).toUpperCase());
                index++;
            } else {
                sb.append(c);
                index++;
            }
        }

        return sb.toString();

//         두번째 풀이
//        String[] list = s.split("");
//        StringBuilder sb = new StringBuilder();
//        int index = 0;
//
//        for(String str : list) {
//            index = (str.equals(" ")) ? 0 : index + 1;
//            sb.append(index % 2 == 0 ? str.toLowerCase() : str.toUpperCase());
//        }
//        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(solution("try hello world")).isEqualTo("TrY HeLlO WoRlD");
        assertThat(solution("a")).isEqualTo("A");
        assertThat(solution("AA A a a A A")).isEqualTo("Aa A A A A A");
        assertThat(solution("A     A a a A A")).isEqualTo("A     A A A A A");
        assertThat(solution("a    ")).isEqualTo("A    ");
    }
}
