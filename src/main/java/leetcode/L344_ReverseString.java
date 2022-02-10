package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L344_ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    @Test
    public void test() {
        //given
        char[] input1 = {'h', 'e', 'l', 'l', 'o'};
        char[] output1 = {'o', 'l', 'l', 'e', 'h'};

        char[] input2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] output2 = {'h', 'a', 'n', 'n', 'a', 'H'};

        //when
        reverseString(input1);
        reverseString(input2);

        //then
        assertThat(input1).isEqualTo(output1);
        assertThat(input2).isEqualTo(output2);
    }
}
