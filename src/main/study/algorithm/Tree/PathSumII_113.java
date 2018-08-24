package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rst = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(root, sum, rst, list);
        return rst;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> rst, List<Integer> list) {
        if (root == null) {
            return;
        }


        if (root.val == sum && root.left == null && root.right == null) {
            list.add(root.val);
            rst.add(new ArrayList<>(list));
            list.remove(list.size()-1); // make sure remove this from the list
            return;
        }

        list.add(root.val);
        helper(root.left, sum - root.val, rst, list);
        helper(root.right, sum - root.val, rst, list);
        list.remove(list.size()-1);
    }

}
