/*
Description
대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요.
'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
예를들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

제한사항
문자열 s의 길이 : 50 이하의 자연수
문자열 s는 알파벳으로만 이루어져 있습니다.
 */
package programmers.level1;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class 문자열내p와y의개수 {

    boolean solution(String s) {
        // 첫번째 풀이
        ArrayList<String> list = new ArrayList<>();
        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i, i + 1));
        }

        for (String a : list) {
            if (a.equals("P")) {
                p += 1;
            } else if (a.equals("p")) {
                p += 1;
            } else if (a.equals("Y")) {
                y += 1;
            } else if (a.equals("y")) {
                y += 1;
            }
        }

        return p == y;

//        두번째 풀이
//        s = s.toLowerCase();
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == 'p') count++;
//            if (s.charAt(i) == 'y') count--;
//        }
//
//        return count == 0;

//        세번째풀이
//        int count = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.substring(i, i + 1).equalsIgnoreCase("p")) count++;
//            if (s.substring(i, i + 1).equalsIgnoreCase("y")) count--;
//        }
//
//        return count == 0;


    }

    @Test
    public void test() {
        assertThat(solution("pPoooyY")).isEqualTo(true);
        assertThat(solution("Pyy")).isEqualTo(false);
        assertThat(solution("PyY")).isEqualTo(false);
        assertThat(solution("abc")).isEqualTo(true);

    }
}
