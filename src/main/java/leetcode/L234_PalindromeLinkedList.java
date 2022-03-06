package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class L234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // 첫 풀이
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if(list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
        assertThat(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))))
                .isEqualTo(true);
        assertThat(isPalindrome(new ListNode(1, new ListNode(2))))
                .isEqualTo(false);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
