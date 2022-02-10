package programmers.kakao.level1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 2018 카카오 블라인드 채용
public class 다트게임 {
    public int solution(String dartResult) {
        int result = 0;

        double beforeBase = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c == 'S' || c == 'D' || c == 'T') {
                double base = dartResult.charAt(i - 1) - 48;
                if (i - 2 >= 0 && dartResult.charAt(i - 2) == '1') base = 10;
                if (c == 'D') base = Math.pow(base, 2);
                if (c == 'T') base = Math.pow(base, 3);

                if (i + 1 < dartResult.length()) {
                    if (dartResult.charAt(i + 1) == '*') {
                        base *= 2;
                        result += beforeBase;
                    } else if (dartResult.charAt(i + 1) == '#') {
                        base *= -1;
                    }
                }

                result += base;
                beforeBase = base;
            }
        }

        return result;
    }

    @Test
    public void test() {
        assertThat(solution("1S2D*3T")).isEqualTo(37);
        assertThat(solution("1D2S#10S")).isEqualTo(9);
        assertThat(solution("1D2S0T")).isEqualTo(3);
        assertThat(solution("1S*2T*3S")).isEqualTo(23);
        assertThat(solution("1D#2S*3S")).isEqualTo(5);
        assertThat(solution("1T2D3D#")).isEqualTo(-4);
        assertThat(solution("1D2S3T*")).isEqualTo(59);
    }
}
