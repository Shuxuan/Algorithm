package main.study.algorithm.Tree;

import java.util.Stack;

/**
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 *
 */
public class KthSmallestElementinaBST_213 {

    public int kthSmallest(TreeNode root, int k) {

        // inorder iteration, find the kth element

        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        int rst = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            i++;
            if (i == k) {
                rst = root.val;
                break;
            }
            root = root.right;
        }

        return rst;

    }
}
