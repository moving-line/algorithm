package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class L101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        // 첫 풀이
        Stack<TreeNode> stackL = new Stack<>();
        Stack<TreeNode> stackR = new Stack<>();
        stackL.push(root.left != null ? root.left : null);
        stackR.push(root.right != null ? root.right : null);

        while (!stackL.isEmpty() && !stackR.isEmpty()) {
            TreeNode nodeL = stackL.pop();
            TreeNode nodeR = stackR.pop();

            if (nodeL != null && nodeR != null) {
                if (nodeL.val == nodeR.val) { // 대칭되는 값이 같음.. OK 대칭비교 가능하게 다음요소주입
                    stackL.push(nodeL.right);
                    stackR.push(nodeR.left);

                    stackL.push(nodeL.left);
                    stackR.push(nodeR.right);
                } else return false; // 대칭되는 값이 틀림.. Wrong

            } else {
                if (nodeL == null && nodeR == null) {}// 둘 다 null.. OK
                else return false; // 하나는 널, 하나는 값이 있음.. Wrong
            }
        }

        return true;

        // 스택 하나만 쓰기
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root.left);
//        stack.push(root.right);
//
//        while (!stack.isEmpty()) {
//            TreeNode left = stack.pop();
//            TreeNode right = stack.pop();
//
//            if (left == null && right == null) continue;
//            if (left == null || right == null || left.val != right.val) return false;
//
//            stack.push(left.right);
//            stack.push(right.left);
//            stack.push(left.left);
//            stack.push(right.right);
//        }
//
//        return true;

        // 재귀 절거워~
//        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Test
    void test() {
        assertThat(isSymmetric(new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3))))).isEqualTo(true);

        assertThat(isSymmetric(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3))))).isEqualTo(false);

        assertThat(isSymmetric(new TreeNode(1,
                new TreeNode(2), new TreeNode(3)))).isEqualTo(false);

        assertThat(isSymmetric(new TreeNode(1,
                new TreeNode(0), null))).isEqualTo(false);

        assertThat(isSymmetric(new TreeNode(1,
                new TreeNode(3, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(4), new TreeNode(5))))).isEqualTo(false);
    }
}
