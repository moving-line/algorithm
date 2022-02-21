package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        // 첫 풀이
        int sum = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            sum += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, length - 1 - i);
        }

        return sum;

        // 좀 더 간결
//        int sum = 0;
//        for (char c : columnTitle.toCharArray()) {
//            sum *= 26;
//            sum += (c - 'A' + 1);
//        }
//        return sum;
    }

    @Test
    void test() {
        assertThat(titleToNumber("A")).isEqualTo(1);
        assertThat(titleToNumber("AB")).isEqualTo(28);
        assertThat(titleToNumber("ZY")).isEqualTo(701);
    }
}
