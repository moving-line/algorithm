package leetcode;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class L13_RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5);
        map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int now = map.get(s.charAt(i));

            if (i + 1 < s.length() && now < map.get(s.charAt(i + 1))) {
                sum -= now;
            } else {
                sum += now;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        assertThat(romanToInt("III")).isEqualTo(3);
        assertThat(romanToInt("LVIII")).isEqualTo(58);
        assertThat(romanToInt("MCMXCIV")).isEqualTo(1994);
    }
}
