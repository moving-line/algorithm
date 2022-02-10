package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class L26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // 첫 풀이
        int num = 101;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == num) {
                nums[i] = 101;
            } else {
                num = nums[i];
                k++;
            }
        }
        Arrays.sort(nums);

        return k;

        // 추가 정렬없이 리팩토링. 생긴건 이중루프지만 실제 동작은 그렇지않음
//        if(nums.length == 0) return 0;
//
//        int j = 1; int k = 1;
//        for (int i = 0; i < nums.length; i++) {
//            while (j < nums.length) {
//                if(nums[i] == nums[j]) {
//                    j++;
//                    continue;
//                }
//                nums[i + 1] = nums[j];
//                j++; k++;
//                break;
//            }
//        }
//
//        return k;

        // 모범답안. 리팩토링을 간결하게
//        if (nums.length == 0) return 0;
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;
    }

    @Test
    public void test() {
        assertThat(removeDuplicates(new int[]{1, 1, 2})).isEqualTo(2);
        assertThat(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})).isEqualTo(5);
        assertThat(removeDuplicates(new int[]{})).isEqualTo(0);
        assertThat(removeDuplicates(new int[]{0})).isEqualTo(1);
    }
}
