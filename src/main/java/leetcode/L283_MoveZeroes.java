package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 첫풀이. 추가배열 사용(쓰지않는게문제조건.첫스텝용으로해봄)
        int[] arr = new int[nums.length];
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                arr[j++] = num;
            }
        }

        System.arraycopy(arr, 0, nums, 0, nums.length);

        // 추가배열 X
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == 0) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if(nums[j] != 0) {
//                        nums[i] = nums[j];
//                        nums[j] = 0;
//                        break;
//                    }
//                }
//            }
//        }

        // 최적화
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[j++] = nums[i];
//            }
//        }
//        for (int i = j; i < nums.length; i++) {
//            nums[i] = 0;
//        }

        // 아예 한 루프에~
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//                j++;
//            }
//        }
    }

    @Test
    void test() {
        //given
        int[] input1 = new int[]{0, 1, 0, 3, 12};
        int[] result1 = new int[]{1, 3, 12, 0, 0};
        //when
        moveZeroes(input1);
        //then
        assertThat(input1).isEqualTo(result1);

        //given
        int[] input2 = new int[]{0};
        int[] result2 = new int[]{0};
        //when
        moveZeroes(input2);
        //then
        assertThat(input2).isEqualTo(result2);

        //given
        int[] input3 = new int[]{2, 1};
        int[] result3 = new int[]{2, 1};
        //when
        moveZeroes(input3);
        //then
        assertThat(input3).isEqualTo(result3);
    }
}
