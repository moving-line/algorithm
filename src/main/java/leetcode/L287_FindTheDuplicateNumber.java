package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class L287_FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // 첫풀이. 공간상수x
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return nums[0];

        // 배열. 공간상수x
//        boolean[] arr = new boolean[nums.length - 1];
//        for (int num : nums) {
//            if(arr[num - 1]) {
//                return num;
//            } else {
//                arr[num - 1] = true;
//            }
//        }
//
//        return 0;

        // 이진탐색
//        int left = 1;
//        int right = nums.length - 1;
//
//        int answer = -1;
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            int count = 0;
//
//            for (int num : nums) {
//                if (num <= mid)
//                    count++;
//            }
//
//            if (count > mid) {
//                answer = mid;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return answer;

        // 토-거. 아우 어려워..
//        int slow = nums[0];
//        int fast = nums[0];
//        do {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//        } while (slow != fast);
//
//        slow = nums[0];
//        while (slow != fast) {
//            slow = nums[slow];
//            fast = nums[fast];
//        }
//
//        return fast;
    }

    @Test
    void test() {
        assertThat(findDuplicate(new int[]{1, 3, 4, 2, 2})).isEqualTo(2);
        assertThat(findDuplicate(new int[]{3, 1, 3, 4, 2})).isEqualTo(3);
    }
}
