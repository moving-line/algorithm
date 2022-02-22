package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L191_NumberOf1Bits {
    public int hammingWeight(int n) {

        // 첫 풀이
        int answer = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if(c == '1') {
                answer++;
            }
        }

        return answer;

        // 비트연산
//        int answer = 0;
//        while(n != 0) {
//            answer = answer + (n & 1);
//            n = n >>> 1;
//        }
//
//        return answer;
    }

    @Test
    void test() {
        assertThat(hammingWeight(0b00000000000000000000000000001011)).isEqualTo(3);
        assertThat(hammingWeight(0b00000000000000000000000010000000)).isEqualTo(1);
        assertThat(hammingWeight(0b11111111111111111111111111111101)).isEqualTo(31);
    }
}
