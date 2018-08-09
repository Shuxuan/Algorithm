package main.study.algorithm.DynamicProgramming;

import main.study.algorithm.Tree.TreeNode;

import java.util.ArrayList;
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

        if (n <= 0)
            return new ArrayList<>();

        return dfs(1, n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> rst = new ArrayList<>();

        if (start > end) {
            rst.add(null);
            return rst;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i-1);
            List<TreeNode> right = dfs(i+1, end);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    rst.add(root);
                }
            }
        }

        return rst;
    }
}
