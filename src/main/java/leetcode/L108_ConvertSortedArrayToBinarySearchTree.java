package leetcode;

import org.junit.jupiter.api.Test;

public class L108_ConvertSortedArrayToBinarySearchTree {

    // 재귀 첫 풀이
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;

        int mid = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;

        int[] leftNums = null;
        if (mid - left > 0) {
            leftNums = new int[mid - left];
            for (int i = left; i < mid; i++) {
                leftNums[i] = nums[i];
            }
        }

        int[] rightNums = null;
        if (right - mid > 0) {
            rightNums = new int[right - mid];
            for (int i = mid + 1; i <= right; i++) {
                rightNums[i - (mid + 1)] = nums[i];
            }
        }

        return new TreeNode(nums[mid], sortedArrayToBST(leftNums), sortedArrayToBST(rightNums));
    }

    // 재귀 업그레이드
//    public TreeNode sortedArrayToBST(int[] nums) {
//        if (nums.length == 0) return null;
//        return helper(nums, 0, nums.length - 1);
//    }
//
//    public TreeNode helper(int[] nums, int left, int right) {
//        if (left > right) return null;
//        int mid = (left + right) / 2;
//        return new TreeNode(
//                nums[mid], helper(nums, left, mid - 1), helper(nums, mid + 1, right)
//        );
//    }

    @Test
    void test() {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}).toString());
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

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

