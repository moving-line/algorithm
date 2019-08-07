package programmers.school;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrimeNum(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private static boolean isPrimeNum(int sum) {
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 2, 3})).isEqualTo(0);
        assertThat(solution(new int[]{1, 2, 3, 4})).isEqualTo(1);
        assertThat(solution(new int[]{1, 2, 7, 6, 4})).isEqualTo(4);
    }
}
