package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class L1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 첫 풀이 브루트포스 n^2
        for (int i = 0; i < nums.length - 1; i++) {
            int base = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (base + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;

        // 해시 n 2개
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int difference = target - nums[i];
//            if (map.containsKey(difference) && map.get(difference) != i) {
//                return new int[]{i, map.get(difference)};
//            }
//        }
//        return null;

        // 해시 n 1개
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int difference = target - nums[i];
//            if (map.containsKey(difference)) {
//                return new int[]{i, map.get(difference)};
//            }
//            map.put(nums[i], i);
//        }
//        return null;
    }

    @Test
    public void test() {
        assertThat(twoSum(new int[]{2, 7, 11, 15}, 9)).isIn(new int[]{0, 1}, new int[]{1, 0});
        assertThat(twoSum(new int[]{3, 2, 4}, 6)).isIn(new int[]{1, 2}, new int[]{2, 1});
        assertThat(twoSum(new int[]{3, 3}, 6)).isIn(new int[]{0, 1}, new int[]{1, 0});
    }
}
