package leetcode;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class L20_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        assertThat(isValid("()")).isEqualTo(true);
        assertThat(isValid("()[]{}")).isEqualTo(true);
        assertThat(isValid("(]")).isEqualTo(false);
    }
}
