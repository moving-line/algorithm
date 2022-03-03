package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class L387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {

        // 첫 풀이. 일단 빠르게 답내봄.
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                return s.indexOf(c);
            }
        }
//        위 루프는 순서없는 해쉬맵이면 이런식으로
//        for (int i = 0; i < s.length(); i++) {
//            if (map.get(s.charAt(i)) == 1)
//                return i;
//        }
        return -1;

        // 링크드해쉬맵 맘에 안들어서 배열로다가 루프 1회로 바꿔봄. 근데 내부에 indexOf라 조삼모사.
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if(s.indexOf(c) == s.lastIndexOf(c)) {
//                return i;
//            }
//        }
//        return -1;

        // 소문자뿐이니까 배열 이런식으로도 속도 최적화도 가능
//        int alpha[] = new int[26];
//
//        for (int i = 0; i < s.length(); i++) {
//            alpha[s.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (alpha[s.charAt(i) - 'a'] == 1) {
//                return i;
//            }
//        }
//        return -1;
    }

    @Test
    void test() {
        assertThat(firstUniqChar("leetcode")).isEqualTo(0);
        assertThat(firstUniqChar("loveleetcode")).isEqualTo(2);
        assertThat(firstUniqChar("aabb")).isEqualTo(-1);


    }
}