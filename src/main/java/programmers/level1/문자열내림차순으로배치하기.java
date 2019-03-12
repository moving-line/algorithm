/*
문제 설명
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.
 */
package programmers.level1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {

        //첫번째 풀이
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) temp.add((int) s.charAt(i));
        int[] list = temp.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

        StringBuilder answer = new StringBuilder();
        for (int i : list) answer.append((char) i);

        return answer.toString();

//        두번째 풀이
//        char[] list = s.toCharArray();
//        Arrays.sort(list);
//
//        StringBuilder answer = new StringBuilder();
//        for (int i = list.length - 1; i >= 0; i--) answer.append(list[i]);
//
//        return answer.toString();

//        세번째 풀이
//        char[] list = s.toCharArray();
//        Arrays.sort(list);
//
//        return new StringBuilder(new String(list)).reverse().toString();
    }

    @Test
    public void test() {
        assertThat(solution("AcBabC")).isEqualTo("cbaCBA");
    }

}
