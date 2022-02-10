/*
문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
 */
package programmers.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 가운데글자가져오기 {
    public String solution(String s) {
        int mid = s.length();

        return (mid % 2 == 0) ?
                s.substring(mid/2 - 1, mid/2 + 1) : s.substring(mid/2, mid/2 + 1);
    }

    @Test
    public void test() {
        assertThat(solution("abcde")).isEqualTo("c");
        assertThat(solution("qwer")).isEqualTo("we");
    }
}
