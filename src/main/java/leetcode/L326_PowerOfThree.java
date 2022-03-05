package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        // 첫풀이
        while (n > 3) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return n == 3 || n == 1;

        // 좀더 깔끔?
//        if (n < 1) {
//            return false;
//        }
//
//        while (n % 3 == 0) {
//            n /= 3;
//        }
//
//        return n == 1;

        // 재귀
//        if(n > 3) {
//            return isPowerOfThree(n % 3 == 0 ? n / 3 : 0);
//        }
//        return n == 3 || n == 1;

        // 3진수
//        return Integer.toString(n, 3).matches("^10*$");
    }

    @Test
    void test() {
        assertThat(isPowerOfThree(27)).isEqualTo(true);
        assertThat(isPowerOfThree(0)).isEqualTo(false);
        assertThat(isPowerOfThree(1)).isEqualTo(true);
        assertThat(isPowerOfThree(9)).isEqualTo(true);
    }
}
