package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class L128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 정렬. 단, nlogn
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int count = 1;
        int maxCount = 1;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int before = nums[i - 1];

            if (curr == before + 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else if (curr != before - 1 && curr != before) {
                count = 1;
            }
        }

        return maxCount;

        // 해시
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        int maxCount = 0;
//        for (int num : set) {
//            if (!set.contains(num - 1)) {
//                int count = 1;
//                while (set.contains(num + 1)) {
//                    num++;
//                    count++;
//                }
//                maxCount = Math.max(maxCount, count);
//            }
//        }
//
//        return maxCount;
    }

    @Test
    void test() {
        assertThat(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2})).isEqualTo(4);
        assertThat(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})).isEqualTo(9);
        assertThat(longestConsecutive(new int[]{1, 2, 0, 1})).isEqualTo(3);
        assertThat(longestConsecutive(new int[]{})).isEqualTo(0);
        assertThat(longestConsecutive(new int[]{0})).isEqualTo(1);
    }
}
