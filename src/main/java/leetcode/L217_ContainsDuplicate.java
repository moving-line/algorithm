package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class L217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // 첫풀이
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;

        // 스트림
//        Set<Integer> set = new HashSet<>();
//        return Arrays.stream(nums).anyMatch(num -> !set.add(num));
//        return !Arrays.stream(nums).allMatch(set::add);

        // 정렬
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                return true;
//            }
//        }
//        return false;

    }

    @Test
    void test() {
        assertThat(containsDuplicate(new int[]{1, 2, 3, 1})).isEqualTo(true);
        assertThat(containsDuplicate(new int[]{1, 2, 3, 4})).isEqualTo(false);
        assertThat(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})).isEqualTo(true);
    }
}
