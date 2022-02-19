package leetcode;

import java.util.Stack;

public class L155_MinStack {
    // 첫풀이. 다른 자료구조 안쓰기. 앤드포인트 예외는 생략
    class MinStack {
        private int[] arr;
        private int top;
        private int min;

        public MinStack() {
            arr = new int[10];
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if(top >= arr.length) {
                int[] newArr = new int[arr.length + 10];
                System.arraycopy(arr, 0, newArr, 0, top);
                arr = newArr;
            }

            arr[top++] = val;

            if(min > val) min = val;
        }

        public void pop() {
            top--;

            min = Integer.MAX_VALUE;
            for (int i = 0; i < top; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                }
            }
        }

        public int top() {
            return arr[top - 1];
        }

        public int getMin() {
            return min;
        }
    }

    // 노드 사용
//    class MinStack {
//        private Node head;
//
//        public void push(int x) {
//            if (head == null) {
//                head = new Node(x, x, null);
//            } else {
//                head = new Node(x, Math.min(head.min, x), head);
//            }
//        }
//
//        public void pop() {
//            head = head.next;
//        }
//
//        public int top() {
//            return head.val;
//        }
//
//        public int getMin() {
//            return head.min;
//        }
//
//        private class Node {
//            int val;
//            int min;
//            Node next;
//
//            private Node(int val, int min, Node next) {
//                this.val = val;
//                this.min = min;
//                this.next = next;
//            }
//        }
//    }
}
