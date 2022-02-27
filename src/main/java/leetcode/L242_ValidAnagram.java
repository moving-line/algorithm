package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class L242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        //첫풀이
        if(s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char before = s.charAt(i);
            char after = t.charAt(i);
            map.put(before, map.getOrDefault(before, 0) + 1);
            map.put(after, map.getOrDefault(after, 0) - 1);
        }

        for (Integer value : map.values()) {
            if(value != 0) return false;
        }
        return true;

        // 배열
//        if (s.length() != t.length()) return false;
//
//        char[] c1 = s.toCharArray(), c2 = t.toCharArray();
//        int[] alpha = new int[26];
//        for (int i = 0; i < c1.length; ++i) {
//            alpha[c1[i] - 'a']++;
//            alpha[c2[i] - 'a']--;
//        }
//
//        for (int num : alpha) {
//            if (num != 0) return false;
//        }
//        return true;
    }

    @Test
    void test() {
        assertThat(isAnagram("anagram", "nagaram")).isEqualTo(true);
        assertThat(isAnagram("rat", "car")).isEqualTo(false);
    }
}
