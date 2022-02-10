/*
문제 설명
JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

제한 조건
s는 길이 1 이상인 문자열입니다.
s는 알파벳과 공백문자(" ")로 이루어져 있습니다.
첫 문자가 영문이 아닐때에는 이어지는 영문은 소문자로 씁니다. ( 첫번째 입출력 예 참고 )
 */

package programmers.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JadenCase문자열만들기 {
    public String solution(String s) {
        String[] arr = s.split(" ");

        if (s.charAt(s.length() - 1) == 32) {
            for (int i = s.length() - 1; i > 0; i--) {
                if (s.charAt(i) != 32) break;
                arr[arr.length - 1] += " ";
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("")) continue;
            arr[i] = arr[i].toLowerCase();

            char target = arr[i].charAt(0);
            if (target < 123 && target > 96) {
                arr[i] = arr[i].replaceFirst(String.valueOf(target), String.valueOf((char) (target - 32)));
            }
        }

        return String.join(" ", arr);
    }

//    다른 풀이
//    public String solution(String s) {
//        StringBuilder answer = new StringBuilder();
//        String[] arr = s.toLowerCase().split("");
//        boolean upperFlag = true;
//
//        for(String s1 : arr) {
//            answer.append(upperFlag ? s1.toUpperCase() : s1);
//            upperFlag = s1.equals(" ");
//        }
//
//        return answer.toString();
//    }

    @Test
    public void test() {
        assertThat(solution(" 3people unFollowed me ")).isEqualTo(" 3people Unfollowed Me ");
        assertThat(solution("3people unFollowed me")).isEqualTo("3people Unfollowed Me");
        assertThat(solution("for the last week")).isEqualTo("For The Last Week");
        assertThat(solution("for  the last week")).isEqualTo("For  The Last Week");
        assertThat(solution("for  the last week  ")).isEqualTo("For  The Last Week  ");
        assertThat(solution("  for  the last week  ")).isEqualTo("  For  The Last Week  ");
        assertThat(solution(" for  the last week  ")).isEqualTo(" For  The Last Week  ");
    }
}
