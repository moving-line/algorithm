package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L66_PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i]++ < 9) return digits;
            digits[i] = 0;
        }

        int[] carryResult = new int[digits.length + 1];
        carryResult[0] = 1;
        return carryResult;
    }

    @Test
    public void test() {
        assertThat(plusOne(new int[]{1, 2, 3})).isEqualTo(new int[]{1, 2, 4});
        assertThat(plusOne(new int[]{4, 3, 2, 1})).isEqualTo(new int[]{4, 3, 2, 2});
        assertThat(plusOne(new int[]{9})).isEqualTo(new int[]{1, 0});
        assertThat(plusOne(new int[]{8, 9, 9, 9})).isEqualTo(new int[]{9, 0, 0, 0});
        assertThat(plusOne(new int[]{5, 6, 2, 0, 0, 4, 6, 2, 4, 9})).isEqualTo(new int[]{5, 6, 2, 0, 0, 4, 6, 2, 5, 0});
        assertThat(plusOne(new int[]{5, 2, 2, 6, 5, 7, 1, 9, 0, 3, 8, 6, 8, 6, 5, 2, 1, 8, 7, 9, 8, 3, 8, 4, 7, 2, 5, 8, 9})).isEqualTo(new int[]{5, 2, 2, 6, 5, 7, 1, 9, 0, 3, 8, 6, 8, 6, 5, 2, 1, 8, 7, 9, 8, 3, 8, 4, 7, 2, 5, 9, 0});
    }
}
