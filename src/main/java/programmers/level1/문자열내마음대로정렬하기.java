/*
문제 설명
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.

제한 조건
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
 */

package programmers.level1;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
//        첫번째 풀이
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String s : strings) {
            sb.append(s, n, n + 1);
            sb.append(s);

            list.add(sb.toString());
            sb.setLength(0);
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;

//        두번째 풀이
//        Arrays.sort(strings, (s1, s2) -> {
//            if(s1.charAt(n) > s2.charAt(n)) return 1;
//            else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
//            else if(s1.charAt(n) < s2.charAt(n)) return -1;
//            else return 0;
//        });
//        return strings;
    }

    @Test
    public void test() {
        assertThat(solution(new String[] {"sun", "bed", "car"}, 1)).isEqualTo(new String[] {"car", "bed", "sun"});
        assertThat(solution(new String[] {"abce", "abcd", "cdx"}, 2)).isEqualTo(new String[] {"abcd", "abce", "cdx"});
        assertThat(solution(new String[] {"abce", "abcd", "abcx"}, 2)).isEqualTo(new String[] {"abcd", "abce", "abcx"});
    }
}
