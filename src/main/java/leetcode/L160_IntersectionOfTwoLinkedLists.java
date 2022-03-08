package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class L160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 첫풀이
//        Set<ListNode> set = new HashSet<>();
//        while (headA != null) {
//            set.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (set.contains(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//
//        return null;

        // 모범답안
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

        // 신기한 솔루션
//        if (headA == null || headB == null) return null;
//        ListNode a = headA;
//        ListNode b = headB;
//
//        while (a != b) {
//            a = a == null ? headB : a.next;
//            b = b == null ? headA : b.next;
//        }
//
//        return a;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    void test() {
        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5)));
        assertThat(getIntersectionNode(
                new ListNode(4, new ListNode(1, intersect)),
                new ListNode(5, new ListNode(6, new ListNode(1, intersect)))))
                .isEqualTo(intersect);

        ListNode intersect2 = new ListNode(2, new ListNode(4));
        assertThat(getIntersectionNode(
                new ListNode(1, new ListNode(9, new ListNode(1, intersect2))),
                new ListNode(3, new ListNode(1, intersect2))))
                .isEqualTo(intersect2);

        assertThat(getIntersectionNode(
                new ListNode(2, new ListNode(6, new ListNode(4))),
                new ListNode(1, new ListNode(5))))
                .isEqualTo(null);
    }
}
