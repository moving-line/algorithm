package programmers.school;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 하샤드수 {
    public boolean solution(int x) {
        int sum = 0;
        int num = x;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return x % sum == 0;
    }

    @Test
    public void test() {
        assertThat(solution(10)).isEqualTo(true);
        assertThat(solution(12)).isEqualTo(true);
        assertThat(solution(11)).isEqualTo(false);
        assertThat(solution(13)).isEqualTo(false);
    }
}
