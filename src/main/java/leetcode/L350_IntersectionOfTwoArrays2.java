package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class L350_IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //첫 풀이
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();

        int k = 0;
        for (int i1 : nums1) {
            for (int j = k; j < nums2.length; j++) {
                if (i1 == nums2[j]) {
                    list.add(i1);
                    k = j + 1;
                    break;
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();

        // 정렬없이
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : nums1) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i : nums2) {
//            if (map.get(i) != null && map.get(i) > 0) {
//                list.add(i);
//                map.put(i, map.get(i) - 1);
//            }
//        }
//
//        return list.stream().mapToInt(i -> i).toArray();
    }

    @Test
    void test() {
        assertThat(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})).isEqualTo(new int[]{2, 2});
        assertThat(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).isIn(new int[]{4, 9}, new int[]{9, 4});
    }
}