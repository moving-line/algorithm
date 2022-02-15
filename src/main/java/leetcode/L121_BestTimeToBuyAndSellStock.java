package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // 시간초과
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
            }
        }
        return maxProfit;

        // Kadane's Algorithm
//        int maxProfit = 0;
//        int minPrice = Integer.MAX_VALUE;
//
//        for (int price : prices) {
//            if (price < minPrice) {
//                minPrice = price;
//            }
//            maxProfit = Math.max(price - minPrice, maxProfit);
//        }
//        return maxProfit;
    }

    @Test
    void test() {
        assertThat(maxProfit(new int[]{7, 1, 5, 3, 6, 4})).isEqualTo(5);
        assertThat(maxProfit(new int[]{7, 6, 4, 3, 1})).isEqualTo(0);
    }
}
