package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        // 첫풀이
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.get(head) != null) {
                return true;
            }
            map.put(head, 1);
            head = head.next;
        }
        return false;

        // 공간마저 O(1)로. Floyd's Tortoise and Hare Algorithm
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//
//            if (slow == fast)
//                return true;
//        }
//        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}