package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class L94_BinaryTreeInorderTraversal {
    // inorder traversal 중위 순회 : 왼 -> 중 -> 오른

    public List<Integer> inorderTraversal(TreeNode root) {
        // 첫풀이. 절거운 재귀~
        if (root == null) return new ArrayList<>();

        List<Integer> left = inorderTraversal(root.left);
        left.add(root.val);
        List<Integer> right = inorderTraversal(root.right);

        return Stream.concat(left.stream(), right.stream())
                .collect(Collectors.toList());

        // 모범답안 재귀
//        List<Integer> nums = new ArrayList<>();
//        inorder(root, nums);
//        return nums;

        // DFS : stack
//        List<Integer> answer = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            answer.add(root.val);
//            root = root.right;
//        }
//
//        return answer;
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root != null) {
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }
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
        assertThat(inorderTraversal(new TreeNode(1,
                null, new TreeNode(2,
                new TreeNode(3), null)))).isEqualTo(List.of(1, 3, 2));
        assertThat(inorderTraversal(new TreeNode(1))).isEqualTo(List.of(1));
        assertThat(inorderTraversal(null)).isEqualTo(List.of());
    }
}
