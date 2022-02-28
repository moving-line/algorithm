package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class L268_MissingNumber {
    public int missingNumber(int[] nums) {

        // 첫 풀이. 정렬 후 선형루프
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] != i) {
                return i;
            }
        }

        return nums[n - 1] != n ? n : nums[n - 1];

        // 정렬 후 이진탐색
//        Arrays.sort(nums);
//
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//
//            if (nums[mid] > mid) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;

        // 정렬없이 해시
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//
//        for (int i = 0; i <= nums.length; i++) {
//            if (!set.contains(i)) {
//                return i;
//            }
//        }
//
//        return 0;

        // 합 아이디어
//        int n = nums.length;
//        int sum = (n * (n + 1)) / 2;
//        for (int num : nums) {
//            sum -= num;
//        }
//        return sum;


        // XOR 연산. a^a^b=b 에서 착안.
//        int xor = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            xor ^= i ^ nums[i];
//        }
//
//        return xor;

    }

    @Test
    void test() {
        assertThat(missingNumber(new int[]{3, 0, 1})).isEqualTo(2);
        assertThat(missingNumber(new int[]{0, 1})).isEqualTo(2);
        assertThat(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
    }
}
