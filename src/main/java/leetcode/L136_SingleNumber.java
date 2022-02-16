package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class L136_SingleNumber {
    public int singleNumber(int[] nums) {
        // 시간 O(n). but 공간도 O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if(map.get(num) == 1) return num;
        }

        return 1;

        // XOR 연산. 이건 공간마저 상수.
//        int answer = 0;
//        for (int num : nums) {
//            answer ^= num;
//        }
//        return answer;
    }

    @Test
    void test() {
        assertThat(singleNumber(new int[]{2, 2, 1})).isEqualTo(1);
        assertThat(singleNumber(new int[]{4, 1, 2, 1, 2})).isEqualTo(4);
        assertThat(singleNumber(new int[]{1})).isEqualTo(1);
    }
}
