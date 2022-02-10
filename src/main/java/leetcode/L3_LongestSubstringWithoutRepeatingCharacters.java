package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class L3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 첫풀이
        char[] chars = s.toCharArray();
        int answer = 0;

        List<Character> list;
        for (int i = 0; i < s.length(); i++) {
            list = new ArrayList<>();
            list.add(chars[i]);
            for (int j = i + 1; j < s.length(); j++) {
                if (!list.contains(chars[j])) {
                    list.add(chars[j]);
                } else {
                    break;
                }
            }
            answer = Math.max(answer, list.size());
        }
        return answer;

        // 리팩토링1. 해시 사용
//        char[] chars = s.toCharArray();
//        int answer = 0;
//
//        Map<Character, Integer> map;
//        for (int i = 0; i < s.length(); i++) {
//            map = new HashMap<>();
//            map.put(chars[i], 1);
//
//            for (int j = i + 1; j < s.length(); j++) {
//                if (map.containsKey(chars[j])) {
//                    break;
//                } else {
//                    map.put(chars[j], 1);
//                }
//            }
//            answer = Math.max(answer, map.size());
//        }
//
//        return answer;

        // 리팩토링2. 제약조건을 활용해 작은 배열 사용
//        char[] chars = s.toCharArray();
//        int answer = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            int[] arr = new int[128];
//            arr[chars[i]] = 1;
//            int count = 1;
//
//            for (int j = i + 1; j < s.length(); j++) {
//                if (arr[chars[j]] != 1) {
//                    arr[chars[j]] = 1;
//                    count++;
//                } else {
//                    break;
//                }
//            }
//            answer = Math.max(answer, count);
//        }
//        return answer;


        // 모범답안
//        Integer[] chars = new Integer[128];
//        int left = 0;
//        int right = 0;
//
//        int answer = 0;
//        while (right < s.length()) {
//            char r = s.charAt(right);
//            Integer index = chars[r];
//            if (index != null && index >= left && index < right) {
//                left = index + 1;
//            }
//
//            answer = Math.max(answer, right - left + 1);
//            chars[r] = right;
//            right++;
//        }
//
//        return answer;
    }


    @Test
    public void test() {
        assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
        assertThat(lengthOfLongestSubstring(" ")).isEqualTo(1);
        assertThat(lengthOfLongestSubstring("")).isEqualTo(0);
    }
}
