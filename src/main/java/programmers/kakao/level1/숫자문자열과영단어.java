package programmers.kakao.level1;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 2021 카카오 채용연계 인턴십
public class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < numbers.length; i++) {
            s = s.replaceAll(numbers[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }

    @Test
    public void test() {
        assertThat(solution("one4seveneight")).isEqualTo(1478);
        assertThat(solution("23four5six7")).isEqualTo(234567);
        assertThat(solution("2three45sixseven")).isEqualTo(234567);
        assertThat(solution("123")).isEqualTo(123);
    }
}
