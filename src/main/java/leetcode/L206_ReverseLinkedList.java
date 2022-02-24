package leetcode;

public class L206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        //첫 풀이
//        if (head == null) return null;
//        ListNode node = new ListNode(head.val , null);
//
//        while(head.next != null) {
//            head = head.next;
//            node = new ListNode(head.val, node);
//        }
//
//        return node;

        //모범답안
        ListNode answer = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = answer;
            answer = head;
            head = next;
        }
        return answer;
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
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
