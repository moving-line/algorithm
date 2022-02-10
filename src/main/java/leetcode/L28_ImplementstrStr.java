package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L28_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        // 문자열내 특정 문자열 찾는 C의 strstr()는 java에선 indexOf()
        return haystack.indexOf(needle);

        // 구현. 시간초과 개똥코드
//        if (needle.length() == 0) return 0;
//        if (needle.length() > haystack.length()) return -1;
//
//        int i = 0;
//        boolean check = false;
//        int index = -1;
//
//        for (int j = 0; j < haystack.length(); j++) {
//            if (haystack.charAt(j) == needle.charAt(i)) {
//                if (!check) index = j;
//                check = true;
//                i++;
//                if (i >= needle.length()) break;
//            } else {
//                if (check) {
//                    j = index;
//                    index = -1;
//                }
//                check = false;
//                i = 0;
//            }
//        }
//        if(i < needle.length()) index = -1;
//        return index;

        // 모범답안
//        for (int i = 0; ; i++) {
//            for (int j = 0; ; j++) {
//                if (j == needle.length()) return i;
//                if (i + j == haystack.length()) return -1;
//                if (needle.charAt(j) != haystack.charAt(i + j)) break;
//            }
//        }
    }

    @Test
    public void test() {
        assertThat(strStr("hello", "ll")).isEqualTo(2);
        assertThat(strStr("aaaaa", "bba")).isEqualTo(-1);
        assertThat(strStr("", "")).isEqualTo(0);
        assertThat(strStr("aaa", "aaaa")).isEqualTo(-1);
        assertThat(strStr("mississippi", "issip")).isEqualTo(4);
        assertThat(strStr("mississippi", "issipi")).isEqualTo(-1);
    }
}
