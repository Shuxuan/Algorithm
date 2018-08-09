package main.study.algorithm.DynamicProgramming;

import main.study.algorithm.Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 *
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class UniqueBinarySearchTreesII_95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> rst = new LinkedList<>();
        if (n == 0) {
            return rst;
        }
        //helper(rst, 1, n);
        return rst;
    }

    private TreeNode helper(int start, int end) {
        if (start < end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(start);
        }

        int m = (start + end) / 2;
        TreeNode root = new TreeNode(m);
        TreeNode left = helper(start, m-1);
        TreeNode right = helper((m+1, end));
        root.left = left;
        root.right = right;

        return root;
    }
}
