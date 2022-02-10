package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L69_SqrtX {
    public int mySqrt(int x) {
        // 첫 풀이. long 안쓰게 x를 i로 나눠서 해봄.
        for (int i = 1; i <= x / 2 + 1; i++) {
            if (i > x / i) {
                return i - 1;
            }
        }

        return 1;

        //이진탐색
//        if (x == 0) return 0;
//        int left = 1;
//        int right = x;
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//
//            if ((mid <= x / mid) && ((mid + 1) > x / (mid + 1)))
//                return mid;
//            else if (mid > x / mid)
//                right = mid;
//            else
//                left = mid + 1;
//        }
//
//        return left;
    }

    @Test
    public void test() {
        assertThat(mySqrt(4)).isEqualTo(2);
        assertThat(mySqrt(8)).isEqualTo(2);
        assertThat(mySqrt(0)).isEqualTo(0);
        assertThat(mySqrt(1)).isEqualTo(1);
        assertThat(mySqrt(2)).isEqualTo(1);
    }
}
