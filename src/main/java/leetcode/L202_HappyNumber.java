package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class L202_HappyNumber {
    public boolean isHappy(int n) {

        // 첫 풀이
        int sum = 0;
        Set<Integer> set = new HashSet<>();

        while (sum != 1) {
            sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }

            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;

        // 함수 뽑기
//        Set<Integer> set = new HashSet<>();
//
//        while (n != 1 && !set.contains(n)) {
//            set.add(n);
//            n = getNext(n);
//        }
//
//        return n == 1;

        // 거북이토끼알고리즘 연습
//        int slow = n;
//        int fast = getNext(n);
//        while (fast != 1 && slow != fast) {
//            slow = getNext(slow);
//            fast = getNext(getNext(fast));
//        }
//
//        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }

    @Test
    void test() {
        assertThat(isHappy(19)).isEqualTo(true);
        assertThat(isHappy(2)).isEqualTo(false);
    }


}
