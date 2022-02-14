package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class L118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>(new ArrayList<>());

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                } else {
                    int left = answer.get(i - 1).get(j - 1);
                    int right = answer.get(i - 1).get(j);
                    list.add(left + right);
                }
            }
            answer.add(list);
        }

        return answer;
    }

    @Test
    void test() {
        assertThat(generate(5))
                .isEqualTo(List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1)));

        assertThat(generate(1)).isEqualTo(List.of(List.of(1)));
        assertThat(generate(2)).isEqualTo(List.of(List.of(1), List.of(1, 1)));
    }
}
