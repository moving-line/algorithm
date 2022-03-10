package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L7_ReverseInteger {
    public int reverse(int x) {
        // 치환 후 스왑. 단 long씀...
        if (x == 0) return 0;
        char[] chars = String.valueOf(x).toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[0] == '-') {
                swap(chars, i + 1, chars.length - 1 - i);
            } else {
                swap(chars, i, chars.length - 1 - i);
            }
        }

        long num = Long.parseLong(String.valueOf(chars));
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) num;

        // 나누기. long안씀
//        int answer = 0;
//
//        while (x != 0) {
//            int num = x % 10;
//            x /= 10;
//
//            if (answer > Integer.MAX_VALUE / 10  || (answer == Integer.MAX_VALUE / 10 && num > 7)) return 0;
//            if (answer < Integer.MIN_VALUE / 10 || (answer == Integer.MIN_VALUE / 10 && num < -8)) return 0;
//
//            answer = answer * 10 + num;
//        }
//        return answer;

        // 간단하긴 한데 좀..
//        int answer = 0;
//
//        while (x != 0) {
//            int tail = x % 10;
//            int temp = answer * 10 + tail;
//
//            if ((temp - tail) / 10 != answer) {
//                return 0;
//            }
//
//            answer = temp;
//            x /= 10;
//        }
//        return answer;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    @Test
    void test() {
        assertThat(reverse(123)).isEqualTo(321);
        assertThat(reverse(-123)).isEqualTo(-321);
        assertThat(reverse(120)).isEqualTo(21);
        assertThat(reverse(0)).isEqualTo(0);
        assertThat(reverse(-2_147_483_648)).isEqualTo(0);
    }
}
