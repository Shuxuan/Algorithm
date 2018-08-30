package main.study.algorithm.Tree;

import static java.lang.Math.pow;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 */
public class CountCompleteTreeNodes_222 {

    /**
     * 2的h次方-1，h为该完美二叉树的高度。这道题可以用递归和非递归两种方法来解。
     * 我们先来看递归的方法，思路是分别找出以当前节点为根节点的左子树和右子树的高度并对比，
     * 如果相等，则说明是满二叉树，直接返回节点个数，
     * 如果不相等，则节点个数为左子树的节点个数加上右子树的节点个数再加1(根节点)，
     * 其中左右子树节点个数的计算可以使用递归来计算，
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        int hLeft = leftHeight(root);
        int hRight = rightHeight(root);

        if (hLeft == hRight) {
            return (int)Math.pow(2, hLeft) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }

    private int rightHeight(TreeNode root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.right;
        }

        return h;
    }

}
