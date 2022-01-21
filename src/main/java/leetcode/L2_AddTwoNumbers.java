package leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class L2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 첫 풀이
        Stack<Integer> stack = new Stack<>();
        boolean isUp = false;
        while (l1 != null || l2 != null) {
            int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val);
            if (isUp) sum++;

            if (sum < 10) {
                stack.push(sum);
                isUp = false;
            } else {
                sum -= 10;
                stack.push(sum);
                isUp = true;
            }
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if (isUp) stack.push(1);

        Stack<ListNode> temp = new Stack<>();
        temp.push(new ListNode(stack.pop()));
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pop(), temp.pop());
            temp.push(node);
        }

        return temp.pop();

        // 첫 풀이 리팩토링 : 캐리 플래그 사용. 첫 루프에서 리스트노드 바로 조립
//        ListNode head = new ListNode(0);
//        ListNode now = head;
//        int carry = 0;
//
//        while (l1 != null || l2 != null) {
//            int val1 = (l1 == null) ? 0 : l1.val;
//            int val2 = (l2 == null) ? 0 : l2.val;
//            int sum = val1 + val2 + carry;
//            carry = sum / 10;
//
//            now.next = new ListNode(sum % 10);
//            now = now.next;
//
//            if(l1 != null) l1 = l1.next;
//            if(l2 != null) l2 = l2.next;
//        }
//        if (carry > 0) {
//            now.next = new ListNode(carry);
//        }
//
//        return head.next;

        // 모범 답안
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//
//        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode e1l1 = new ListNode(2, new ListNode(4,new ListNode(3)));
        ListNode e1l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode e1answer = new ListNode(7, new ListNode(0, new ListNode(8)));
        assertThat(addTwoNumbers(e1l1, e1l2)).isEqualTo(e1answer);

        ListNode e2l1 = new ListNode(0);
        ListNode e2l2 = new ListNode(0);
        ListNode e2answer = new ListNode(0);
        assertThat(addTwoNumbers(e2l1, e2l2)).isEqualTo(e2answer);

        ListNode e3l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode e3l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode e3answer = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))));
        assertThat(addTwoNumbers(e3l1, e3l2)).isEqualTo(e3answer);
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
    }
}
