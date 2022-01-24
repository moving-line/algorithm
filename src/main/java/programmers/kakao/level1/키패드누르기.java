package programmers.kakao.level1;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 2020 카카오 인턴십
public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftPos = 30; // 10자리:Y , 1자리:X
        int rightPos = 32;

        for (int num : numbers) {
            if (num == 0) num = 11;

            if (num % 3 == 1) { // 1 4 7
                leftPos = 10 * (num / 3);
                answer.append("L");

            } else if (num % 3 == 0) { // 3 6 9
                rightPos = 10 * (num / 3 - 1) + 2;
                answer.append("R");

            } else { // 2 4 8 0(11)
                int diffL = Math.abs(leftPos % 10 - 1) + Math.abs(leftPos / 10 - num / 3);
                int diffR = Math.abs(rightPos % 10 - 1) + Math.abs(rightPos / 10 - num / 3);

                if (diffL < diffR || (diffL == diffR && hand.equals("left"))) {
                    leftPos = 10 * (num / 3) + 1;
                    answer.append("L");
                } else if (diffL > diffR || (diffL == diffR && hand.equals("right"))) {
                    rightPos = 10 * (num / 3) + 1;
                    answer.append("R");
                }
            }
        }

        return answer.toString();
    }

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right")).isEqualTo("LRLLLRLLRRL");
        assertThat(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left")).isEqualTo("LRLLRRLLLRR");
        assertThat(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right")).isEqualTo("LLRLLRLLRL");
    }
}
