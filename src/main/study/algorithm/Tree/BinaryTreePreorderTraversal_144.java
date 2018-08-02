package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,2,3]
 */
public class BinaryTreePreorderTraversal_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            rst.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }


        return rst;
    }

    public List<Integer> preorderTraversal_recursion(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        helper(root, rst);
        return rst;
    }

    public void helper(TreeNode root, List<Integer> rst) {
        if (root == null) {
            return;
        }

        rst.add(root.val);
        helper(root.left, rst);
        helper(root.right, rst);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);
        root.right = right;
        right.left = rightLeft;

        BinaryTreePreorderTraversal_144 myObj = new BinaryTreePreorderTraversal_144();
        List<Integer> rst = myObj.preorderTraversal(root);
        System.out.println(Arrays.toString(rst.toArray()));
    }
}
