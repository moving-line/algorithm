package programmers.kakao.level2;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

//2020 카카오 블라인드 채용
public class 문자열압축 {
    public int solution(String s) {
        // 첫 풀이
        int length = s.length();
        for (int i = 1; i < s.length(); i++) { // 문자열 길이별 판단. 1부터 끝가지

            StringBuilder str = new StringBuilder();
            String previous = "";
            int count = 1;

            for (int j = 0; j < s.length(); j = j + i) { // 주어진 길이 단위대로 문자열 체크

                StringBuilder current = new StringBuilder();
                for (int k = j; k < (Math.min(j + i, s.length())); k++) {
                    current.append(s.charAt(k)); // 판단할 이번 턴 문자열 생성..
                }

                // 이전길이문자와 지금길이문자기 같은지 비교
                if (current.toString().equals(previous)) {
                    count++;
                } else {
                    str.append(count > 1 ? count : "").append(previous);
                    previous = current.toString();
                    count = 1;
                }
            }

            str.append(count > 1 ? count : "").append(previous); // 남은거 플러쉬
            length = Math.min(length, str.length());
        }

        return length;

        // 리팩토링 1)루프크기축소 2)불필요루프제거 3)문자열합치기관련로직변경
//        int answer = s.length();
//        for (int length = 1; length < s.length() / 2 + 1; length++) { // 1.중간까지만 보면 된다. 이후 크기는 반복이 존재할 수 없으므로..
//            String previous = "";
//            int count = 1;
//            int sum = 0;
//
//            for (int j = 0; j < s.length(); j = j + length) {
//                String current = s.substring(j, Math.min(j + length, s.length())); // 2.루프대신 걍 함수 쓰자
//                if (current.equals(previous)) {
//                    count++;
//                } else { // 3. 문자열합치기고 길이를 계산하는것이 아닌, 애초에 합치기없이 길이를 더하는 로직으로 변경. 문자만들필요없음.
//                    if (count != 1) sum += (Math.log10(count) + 1);
//                    sum += previous.length();
//                    previous = current;
//                    count = 1;
//                }
//            }
//            if (count != 1) sum += (Math.log10(count) + 1);
//            sum += previous.length();
//
//            answer = Math.min(answer, sum);
//        }
//        return answer;
    }

    @Test
    public void test() {
        assertThat(solution("aabbaccc")).isEqualTo(7);
        assertThat(solution("ababcdcdababcdcd")).isEqualTo(9);
        assertThat(solution("abcabcdede")).isEqualTo(8);
        assertThat(solution("abcabcabcabcdededededede")).isEqualTo(14);
        assertThat(solution("xababcdcdababcdcd")).isEqualTo(17);

        assertThat(solution("a")).isEqualTo(1);
        assertThat(solution("aa")).isEqualTo(2);
        assertThat(solution("ab")).isEqualTo(2);
        assertThat(solution("aaa")).isEqualTo(2);
        assertThat(solution("aaab")).isEqualTo(3);
        assertThat(solution("abcdabcda")).isEqualTo(6);
        assertThat(solution("aaaaaaaaaaaabcd")).isEqualTo(6);
    }
}
