package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class L169_MajorityElement {
    public int majorityElement(int[] nums) {
        // 첫 풀이. 시간,공간 둘 다 O(n)
        Map<Integer, Integer> count = new HashMap<>();
        int halfN = nums.length / 2;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > halfN) return num;
        }

        return 0;

        // 정렬.
//        Arrays.sort(nums);
//        return nums[nums.length / 2]; // 갯수가 과반수이상이니 무조건 중간 인덱스에 정답이 존재함

        // Boyer-Moore Voting Algorithm. 넣었다뺐다하면 과반수이상인 녀석이 최후에 남아있을것
//        int count = 1;
//        int major = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            if (count == 0) {
//                major = nums[i];
//                count++;
//            } else if (major == nums[i]) {
//                count++;
//            } else {
//                count--;
//            }
//        }
//
//        return major;
    }

    @Test
    void test() {
        assertThat(majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
        assertThat(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
        assertThat(majorityElement(new int[]{3, 3, 4})).isEqualTo(3);
        assertThat(majorityElement(new int[]{6, 5, 5})).isEqualTo(5);
    }
}
