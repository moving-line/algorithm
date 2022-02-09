package leetcode;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class L104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        // 재귀
        return (root == null) ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        // DFS : stack
//        if (root == null) return 0;
//
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<Integer> depths = new Stack<>();
//        stack.push(root);
//        depths.push(1);
//
//        int maxDepth = 0;
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            int depth = depths.pop();
//            maxDepth = Math.max(depth, maxDepth);
//
//            if (node.right != null) {
//                stack.push(node.right);
//                depths.push(depth + 1);
//            }
//            if (node.left != null) {
//                stack.push(node.left);
//                depths.push(depth + 1);
//            }
//        }
//
//        return maxDepth;

        // BFS : Queue
//        if (root == null) return 0;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int depth = 0;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- > 0) {
//                TreeNode node = queue.poll();
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//            depth++;
//        }
//        return depth;
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
    }

    @Test
    public void test() {
        assertThat(maxDepth(new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                new TreeNode(15), new TreeNode(7))))).isEqualTo(3);
        assertThat(maxDepth(new TreeNode(1,
                null, new TreeNode(2)))).isEqualTo(2);
    }
}
