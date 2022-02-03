package leetcode;

import org.testng.annotations.Test;

public class L21_MergeTwoSortedLists {
    static final int OVER_NUM =101;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode now = new ListNode(0);
        ListNode dummyHead = now;

        while(list1 != null || list2 != null) {

            int val1 = (list1 != null) ? list1.val : OVER_NUM;
            int val2 = (list2 != null) ? list2.val : OVER_NUM;

            if(val1 <= val2) {
                now.next = list1;
                now = now.next;
                list1 = (list1 != null) ? list1.next : null;
            } else {
                now.next = list2;
                now = now.next;
                list2 = (list2 != null) ? list2.next : null;
            }
        }

        return dummyHead.next;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode.toString());
    }

    class ListNode {
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
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
