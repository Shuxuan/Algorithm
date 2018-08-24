package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
public class MinimumDepthofBinaryTree_111 {

    public int minDepth(TreeNode root) {
        int rst = 0;
        if (root == null) {
            return rst;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left != 0 && right != 0) {
            return Math.min(left, right) + 1;
        }

        if (left == 0) {
            rst = right + 1;
        }

        if (right == 0) {
            rst = left + 1;
        }

        return rst;
    }
}
