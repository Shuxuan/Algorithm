package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 */
public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = helper(nums, 0, nums.length - 1);

        return root;

    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        // find the max
        int index = start;
        int max = index;
        while (index <= end) {
            if (nums[index] > nums[max]) {
                max = index;
            }
            index++;
        }

        // max 是最大值的index
        TreeNode root = new TreeNode(nums[max]);
        TreeNode left = helper(nums, start, max - 1);
        TreeNode right = helper(nums, max + 1, end);
        root.left = left;
        root.right = right;

        return root;
    }
}
