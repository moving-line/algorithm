package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class L215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

        // 첫 풀이
        Arrays.sort(nums);
        return nums[nums.length - 1 - (k - 1)];

        // 우선순위큐
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int num : nums) {
//            pq.offer(num);
//            if(pq.size() > k) {
//                pq.poll();
//            }
//        }
//
//        return pq.peek();
    }

    @Test
    void test() {
        assertThat(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
        assertThat(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)).isEqualTo(4);
    }
}
