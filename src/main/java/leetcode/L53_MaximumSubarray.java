package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // 첫풀이 시간초과
        int[] arr = new int[nums.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > arr[i]) {
                    arr[i] = sum;
                }
            }

            max = Math.max(arr[i], max);
        }

        return max;

        // dp 적용
//        int[] dp = new int[nums.length];
//        int max = nums[0];
//        dp[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//            if (dp[i] > max) {
//                max = dp[i];
//            }
//        }
//        return max;

        // Kadane 알고리즘
//        int max = Integer.MIN_VALUE;
//        int sum = 0;
//
//        for (int num : nums) {
//            sum += num;
//            max = Math.max(sum, max);
//
//            if (sum < 0) sum = 0; // 핵심
//        }
//
//        return max;
    }

    @Test
    public void test() {
        assertThat(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);
        assertThat(maxSubArray(new int[]{1})).isEqualTo(1);
        assertThat(maxSubArray(new int[]{5, 4, -1, 7, 8})).isEqualTo(23);
        assertThat(maxSubArray(new int[]{-1})).isEqualTo(-1);
        assertThat(maxSubArray(new int[]{-1, -2, -3, -1})).isEqualTo(-1);
    }
}
