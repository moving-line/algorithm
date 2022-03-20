package leetcode;

public class L162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        // 첫풀이 O(n)
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//        return nums.length - 1;

        // 이진 O(logn)
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int left, int right) {
        if (left == right) return left;
        int mid = (left + right) / 2;

        if (nums[mid] > nums[mid + 1]) {
            return search(nums, left, mid);
        }
        return search(nums, mid + 1, right);
    }
}
