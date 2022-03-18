package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class L102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 리스트
//        List<List<Integer>> answer = new ArrayList<>();
//        if(root == null)  return answer;
//        answer.add(List.of(root.val));
//
//        List<List<TreeNode>> list = new ArrayList<>();
//        list.add(List.of(root));
//
//        while(list.get(list.size() - 1).size() > 0) {
//            List<TreeNode> lastNodes = list.get(list.size() - 1);
//            List<TreeNode> subList = new ArrayList<>();
//            List<Integer> subAnswer = new ArrayList<>();
//
//            for (TreeNode node : lastNodes) {
//                if (node.left != null) {
//                    subList.add(node.left);
//                    subAnswer.add(node.left.val);
//                }
//                if (node.right != null) {
//                    subList.add(node.right);
//                    subAnswer.add(node.right.val);
//                }
//            }
//            list.add(subList);
//            if(subAnswer.size() > 0) answer.add(subAnswer);
//        }
//
//        return answer;

        // 큐
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                list.add(node.val);

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            answer.add(list);
        }

        return answer;
    }

    @Test
    void test() {
        assertThat(levelOrder(new TreeNode(3,
                new TreeNode(9), new TreeNode(20,
                new TreeNode(15), new TreeNode(7)))
        )).isEqualTo(List.of(List.of(3), List.of(9, 20), List.of(15, 7)));

        assertThat(levelOrder(new TreeNode(1))).isEqualTo(List.of(List.of(1)));
    }

    public class TreeNode {
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
}
