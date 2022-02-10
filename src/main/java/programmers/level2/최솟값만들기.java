package programmers.level2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class 최솟값만들기 {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length - 1 - i];
        }

        return sum;
    }

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4})).isEqualTo(29);
        assertThat(solution(new int[]{1, 2}, new int[]{3, 4})).isEqualTo(10);
    }
}
