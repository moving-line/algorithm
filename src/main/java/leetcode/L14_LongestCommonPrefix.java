package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String otherStr = strs[j];
                if(otherStr.length() <= i) {
                    return prefix.toString();
                }
                char otherC = strs[j].charAt(i);
                if(c != otherC) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }

        return prefix.toString();
    }

    @Test
    public void test() {
        assertThat(longestCommonPrefix(new String[] {"flower","flow","flight"})).isEqualTo("fl");
        assertThat(longestCommonPrefix(new String[] {"dog","racecar","car"})).isEqualTo("");
    }
}
