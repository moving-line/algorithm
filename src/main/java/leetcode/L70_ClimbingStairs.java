package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L70_ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n > 1) dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

    @Test
    public void test() {
        assertThat(climbStairs(2)).isEqualTo(2);
        assertThat(climbStairs(3)).isEqualTo(3);
        assertThat(climbStairs(4)).isEqualTo(5);
    }
}
