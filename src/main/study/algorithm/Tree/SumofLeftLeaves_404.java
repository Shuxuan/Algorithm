package main.study.algorithm.Tree;

/**
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 *
 */
public class SumofLeftLeaves_404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            //this is the leaf, how to know this is the left?
            return sum + root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }

}
