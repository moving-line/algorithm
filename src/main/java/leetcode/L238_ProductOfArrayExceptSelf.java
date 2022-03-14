package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class L238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        // n^2 시간초과
//        int[] answer = new int[nums.length];
//        Arrays.fill(answer, 1);
//
//        for (int i = 0; i < answer.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (j != i) {
//                    answer[i] *= nums[j];
//                }
//            }
//        }
//        return answer;

        // 모범답안
        int len = nums.length;
        int[] result = new int[len];

        int left = 1;
        for (int i = 0; i < len; i++) {
            result[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }


    @Test
    void test() {
        assertThat(productExceptSelf(new int[]{1, 2, 3, 4})).isEqualTo(new int[]{24, 12, 8, 6});
        assertThat(productExceptSelf(new int[]{-1, 1, 0, -3, 3})).isEqualTo(new int[]{0, 0, 9, 0, 0});
    }
}
