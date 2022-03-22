package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class L347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            result[i] = pq.poll();
        }
        return result;
    }

    @Test
    void test() {
        assertThat(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)).isEqualTo(new int[]{1, 2});
        assertThat(topKFrequent(new int[]{1}, 1)).isEqualTo(new int[]{1});
    }
}
