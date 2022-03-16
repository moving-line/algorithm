package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L50_Pow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    @Test
    void test() {
        assertThat(myPow(2.00000, 10)).isEqualTo(1024.00000);
        assertThat(myPow(2.10000, 3)).isEqualTo(9.26100);
        assertThat(myPow(2.00000, -2)).isEqualTo(0.25000);
    }
}
