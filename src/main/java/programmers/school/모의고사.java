package programmers.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 모의고사 {
    public int[] solution(int[] answers) {

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] result = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            if (one[i % one.length] == answers[i]) {
                result[0]++;
            }
            if (two[i % two.length] == answers[i]) {
                result[1]++;
            }
            if (three[i % three.length] == answers[i]) {
                result[2]++;
            }
        }

        int max = Arrays.stream(result).max().getAsInt();

        List<Integer> winner = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if(max == result[i]) {
                winner.add(i + 1);
            }
        }

        return winner.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 2, 3, 4, 5})).isEqualTo(new int[]{1});
        assertThat(solution(new int[]{1, 3, 2, 4, 2})).isEqualTo(new int[]{1, 2, 3});
    }
}
