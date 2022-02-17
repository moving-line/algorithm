package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        // 첫 풀이
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (isAlphanumeric(c)) {
                sb.append(c);
            }
        }
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;

        // 첫 루프때 끝내기. 투 포인터
//        char[] chars = s.toLowerCase().toCharArray();
//        int left = 0;
//        int right = chars.length - 1;
//
//        while(left < right) {
//            while(left < chars.length && !isAlphanumeric(chars[left])) {
//                left++;
//            }
//            while(right >= 0 && !isAlphanumeric(chars[right])) {
//                right--;
//            }
//
//            if(left < chars.length && right >= 0
//                    && chars[left] != chars[right]) {
//                return false;
//            }
//            left++; right--;
//        }
//        return true;

        // 두번째 풀이 리팩토링. 예외처리 줄여보기
//        char[] chars = s.toLowerCase().toCharArray();
//        int left = 0;
//        int right = chars.length - 1;
//
//        while(left < right) {
//            if(!isAlphanumeric(chars[left])) left++;
//            else if(!isAlphanumeric(chars[right])) right--;
//            else if(chars[left++] != chars[right--]) {
//                return false;
//            }
//        }
//        return true;

        // 정규표현식 써보기
//        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
//        for (int i = 0; i < s.length() / 2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
//                return false;
//        }
//        return true;
    }

    private boolean isAlphanumeric(char c) {
        // 48 ~ 57 숫자
        // 97 ~ 122 영소문자
        return c >= 48 && c <= 57 || c >= 97 && c <= 122;
    }

    @Test
    void test() {
        assertThat(isPalindrome("A man, a plan, a canal: Panama")).isEqualTo(true);
        assertThat(isPalindrome("race a car")).isEqualTo(false);
        assertThat(isPalindrome(" ")).isEqualTo(true);
        assertThat(isPalindrome(".,")).isEqualTo(true);
    }
}
