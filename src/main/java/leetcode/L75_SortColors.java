package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L75_SortColors {
    public void sortColors(int[] nums) {
        // 빠르지만 하드코딩ㅋㅋㅋㅋ
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) red++;
            if (num == 1) white++;
            if (num == 2) blue++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < red) nums[i] = 0;
            else if (i < red + white) nums[i] = 1;
            else nums[i] = 2;
        }

        // 버블솥
//        int len = nums.length;
//
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len - i - 1; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    swap(nums, j, j + 1);
//                }
//            }
//        }

        // 추천 답안
//        int f = 0;
//        int b = nums.length - 1;
//        int i = 0;
//
//        while (i <= b) {
//            if (nums[i] == 0) {
//                nums[i] = nums[f];
//                nums[f] = 0;
//                f++;
//            }
//            if (nums[i] == 2) {
//                nums[i] = nums[b];
//                nums[b] = 2;
//                b--;
//                i--;
//            }
//            i++;
//        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    void test() {
        int[] origin = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(origin);
        assertThat(origin).isEqualTo(new int[]{0, 0, 1, 1, 2, 2});

        int[] origin2 = new int[]{2, 0, 1};
        sortColors(origin2);
        assertThat(origin2).isEqualTo(new int[]{0, 1, 2});
    }
}
