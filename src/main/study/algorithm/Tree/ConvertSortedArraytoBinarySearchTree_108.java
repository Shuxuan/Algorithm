package main.study.algorithm.Tree;

import apple.laf.JRSUIUtils;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArraytoBinarySearchTree_108 {

    /**
     *
     * @param nums
     * @return
     *
     * using binary search to get mid, which is root,
     * start to mid - 1 is left
     * mid+1 to end is right
     *
     * recursion
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length-1);

    }

    private TreeNode helper(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = helper(nums, start, mid-1);
        TreeNode right = helper(nums, mid + 1, end);
        root.left = left;
        root.right = right;

        return root;
    }

}
