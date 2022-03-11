package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class L179_LargestNumber {
    public String largestNumber(int[] nums) {
        // 첫 풀이
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(boxedNums, (o1, o2) -> {
            String num1Str = String.valueOf(o1);
            String num2Str = String.valueOf(o2);
            return Long.compare(0, Long.parseLong(num1Str + num2Str) - Long.parseLong(num2Str + num1Str));
        });

        if (boxedNums[0] == 0) return "0";

        StringBuilder result = new StringBuilder();
        for (Integer boxedNum : boxedNums) {
            result.append(boxedNum);
        }
        return result.toString();

        // 문자열 배열로. 깔끔!
//        String[] arr = Arrays.stream(nums)
//                            .mapToObj(String::valueOf)
//                            .toArray(String[]::new);
//
//        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
//
//        if (arr[0].equals("0")) return "0";
//
//        StringBuilder result = new StringBuilder();
//        for (String numAsStr : arr) {
//            result.append(numAsStr);
//        }
//        return result.toString();
    }

    @Test
    void test() {
        assertThat(largestNumber(new int[]{10, 2})).isEqualTo("210");
        assertThat(largestNumber(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
        assertThat(largestNumber(new int[]{999999991, 9})).isEqualTo("9999999991");
        assertThat(largestNumber(new int[]{0, 0})).isEqualTo("0");
    }
}
