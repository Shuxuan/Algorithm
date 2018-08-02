package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal_94 {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal_recursion(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        helper(root, rst);
        return rst;
    }

    public void helper(TreeNode root, List<Integer> rst) {
        if (root == null)
            return;
        helper(root.left, rst);
        rst.add(root.val);
        helper(root.right, rst);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);
        root.right = right;
        right.left = rightLeft;

        BinaryTreeInorderTraversal_94 myObj = new BinaryTreeInorderTraversal_94();
        List<Integer> rst = myObj.inorderTraversal(root);
        System.out.println(Arrays.toString(rst.toArray()));
    }


}
