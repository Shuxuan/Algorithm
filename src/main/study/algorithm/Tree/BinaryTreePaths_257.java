package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {

        /**
         * dfs
         */

        List<String> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        dfs(root, rst, "");

        return rst;

    }

    private void dfs(TreeNode root, List<String> rst, String s) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            // reach the leaf node
            String answer = s + "->" + root.val;
            rst.add(answer.substring(2));
            return;

        }

        dfs(root.left, rst, s + "->" + Integer.toString(root.val));
        dfs(root.right, rst, s + "->" + Integer.toString(root.val));

    }


}
