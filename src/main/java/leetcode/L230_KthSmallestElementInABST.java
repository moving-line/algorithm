package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class L230_KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        // 첫 풀이. BFS. 이진탐색트리인지 생각못하고 품;;
        List<Integer> list = new ArrayList<>();
//        Set<Integer> set = new TreeSet<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            list.add(node.val);

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        Collections.sort(list);
        return list.get(k - 1);
//        for (Integer i : set) {
//            if (k-- == 1) return i;
//        }
//        return k;

        // DFS inorder~~
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        root = root.left;
//
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if(k-- == 1) return root.val;
//            root = root.right;
//        }
//
//        return k;

        // 중위순회 재귀로
//        List<Integer> list = new ArrayList<>();
//        inorder(root, list);
//        return list.get(k - 1);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
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
    }

    @Test
    void test() {
        assertThat(kthSmallest(
                new TreeNode(3,
                        new TreeNode(1,
                                null,
                                new TreeNode(2)),
                        new TreeNode(4)),
                1)).isEqualTo(1);

        assertThat(kthSmallest(
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        null),
                                new TreeNode(4)),
                        new TreeNode(6)),
                3)).isEqualTo(3);

        assertThat(kthSmallest(new TreeNode(1, null, new TreeNode(2)), 2)).isEqualTo(2);
    }
}
