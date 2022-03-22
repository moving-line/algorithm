package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class L347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // 우선순위 큐. O(nlogn)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
        pq.addAll(map.keySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    @Test
    void test() {
        assertThat(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).isIn(new int[]{1, 2}, new int[]{2, 1});
        assertThat(topKFrequent(new int[]{1}, 1)).isIn(new int[]{1});
    }
}
