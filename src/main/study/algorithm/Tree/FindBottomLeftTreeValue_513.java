package main.study.algorithm.Tree;

import java.util.*;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 */
public class FindBottomLeftTreeValue_513 {

    /**
     * level order traverse the tree, last level, the first element is the answer
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int rst = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (i == 0) {
                    rst = cur.val;
                }

                if (cur.left != null) {
                    ((LinkedList<TreeNode>) queue).add(cur.left);
                }
                if (cur.right != null) {
                    ((LinkedList<TreeNode>) queue).add(cur.right);
                }
            }

        }

        return rst;
    }
}
