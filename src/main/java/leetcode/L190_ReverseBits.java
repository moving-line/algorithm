package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class L190_ReverseBits {
    public int reverseBits(int n) {
        // 첫풀이
//        char[] bits = Integer.toBinaryString(n).toCharArray();
//        char[] result = new char[32];
//
//        for (int i = 0; i < result.length; i++) {
//            result[i] = (i < bits.length) ? bits[bits.length - 1 - i] : '0';
//        }
//
//        return (int) Long.parseLong(String.valueOf(result), 2);

        // 비트
        int answer = 0;

        for (int i = 0; i < 32; i++) {
            answer <<= 1; // 넣을 칸 만들고
            if ((n & 1) == 1) answer++; // n에서 뽑은 마지막 수가 1이면 answer에 넣자. 0은 디폴트라 넣을필요 x
            n >>= 1; // 위에서 n 마지막 수 뽑았으니 앞으로 한칸 밀어
        }

        return answer;
    }

    @Test
    void test() {
        assertThat(reverseBits(0b00000010100101000001111010011100)).isEqualTo(964176192);
        assertThat(reverseBits(0b11111111111111111111111111111101)).isEqualTo(-1073741825);
    }
}
