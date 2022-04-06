package programmers.kakao.level2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

//2020 카카오 블라인드 채용
public class 괄호변환 {
    public String solution(String p) {
        if (p.equals("")) return "";
        String u = getD(p);
        String v = getV(p);

        return isCorrect(u) ? u + solution(v) : getNonCorrectStr(u, v);
    }

    private String getD(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
                sb.append("(");
            } else if (str.charAt(i) == ')') {
                count--;
                sb.append(")");
            }
            if (count == 0) break;
        }
        return sb.toString();
    }

    private String getV(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            if (str.charAt(i) == ')') count--;
            if (count == 0) {
                for (int j = i + 1; j < str.length(); j++) {
                    sb.append(str.charAt(j));
                }
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private boolean isCorrect(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') count++;
            if (str.charAt(i) == ')') count--;

            if (count == 0) return true;
            if (count < 0) return false;
        }
        return count == 0;
    }

    private String getNonCorrectStr(String u, String v) {
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append(solution(v))
                .append(")");

        if (u.length() > 2) {
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    sb.append(")");
                } else
                    sb.append("(");
            }
        }

        return sb.toString();
    }

    @Test
    void test() {
        assertThat(solution("(()())()")).isEqualTo("(()())()");
        assertThat(solution(")(")).isEqualTo("()");
        assertThat(solution("()))((()")).isEqualTo("()(())()");
    }
}
