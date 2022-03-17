package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class L328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        // 인덱스
        if (head == null || head.next == null) return head;

        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;

        ListNode curr = head.next.next;

        int index = 3;
        while (curr != null) {
            if (index % 2 == 1) {
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            curr = curr.next;
            index++;
        }

        oddTail.next = evenHead;
        evenTail.next = null;

        return head;

        // 인덱스없이
//        if (head == null) return null;
//
//        ListNode oddTail = head;
//        ListNode evenTail = head.next;
//        ListNode evenHead = evenTail;
//
//        while (evenTail != null && evenTail.next != null) {
//            oddTail.next = oddTail.next.next;
//            evenTail.next = evenTail.next.next;
//            oddTail = oddTail.next;
//            evenTail = evenTail.next;
//        }
//        oddTail.next = evenHead;
//
//        return head;
    }

    @Test
    void test() {
        assertThat(oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))))
                .isEqualTo(new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(2, new ListNode(4))))));

        assertThat(oddEvenList(new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))))))
                .isEqualTo(new ListNode(2, new ListNode(3, new ListNode(6, new ListNode(7, new ListNode(1, new ListNode(5, new ListNode(4))))))));


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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
