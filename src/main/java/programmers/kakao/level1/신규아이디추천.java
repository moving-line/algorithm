package programmers.kakao.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 2021 카카오 블라인드 채용
public class 신규아이디추천 {
    public String solution(String new_id) {

        // 첫 풀이
        String str = "";

        str = new_id.toLowerCase();  // 1단계: 소문자로 치환
        str = str.replaceAll("[^a-z0-9-_.]", ""); // 2단계: 소문자,숫자,(-),(_),(.)를 제외한 문자 제거
        str = str.replaceAll("[.]{2,}", "."); // 3단계 : 마침표(.)가 2번 이상 연속된 부분을 하나로 치환
        str = str.replaceAll("^[.]|[.]$", ""); // 4단계 : 마침표(.)가 처음 or 끝에 위치한다면 제거
        str = str.equals("") ? "a" : str; // 5단계 : 빈 문자열이라면, "a" 대입
        // 6단계 : 1) 길이가 16자 이상이면, 첫 15개의 문자만 남김 2) 제거 후 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표(.) 제거
        str = (str.length() > 15) ? str.substring(0, 15) : str;
        str = str.replaceAll("[.]$", "");
        // 7단계 : 길이가 2자 이하라면,마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙임
        StringBuilder sb = new StringBuilder(str);
        while(sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(solution("...!@BaT#*..y.abcdefghijklm")).isEqualTo("bat.y.abcdefghi");
        assertThat(solution("z-+.^.")).isEqualTo("z--");
        assertThat(solution("=.=")).isEqualTo("aaa");
        assertThat(solution("123_.def")).isEqualTo("123_.def");
        assertThat(solution("abcdefghijklmn.p")).isEqualTo("abcdefghijklmn");
    }
}
