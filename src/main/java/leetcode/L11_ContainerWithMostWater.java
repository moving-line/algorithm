package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        // n^2 무식한 풀이
        int maxArea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
        return maxArea;

        // 포인터 접근
//        int left = 0;
//        int right = height.length - 1;
//        int maxArea = 0;
//
//        while (left < right) {
//            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
//            if (height[left] < height[right])
//                left++;
//            else
//                right--;
//        }
//        return maxArea;
    }

    @Test
    public void test() {
        assertThat(maxArea(new int[]{1, 8, 6, 2, 45, 4, 8, 3, 7})).isEqualTo(49);
        assertThat(maxArea(new int[]{1, 1})).isEqualTo(1);
        assertThat(maxArea(new int[]{1, 2, 4, 3})).isEqualTo(4);
        assertThat(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 25, 7})).isEqualTo(49);
        assertThat(maxArea(new int[]{2, 3, 4, 5, 18, 17, 6})).isEqualTo(17);
    }
}
