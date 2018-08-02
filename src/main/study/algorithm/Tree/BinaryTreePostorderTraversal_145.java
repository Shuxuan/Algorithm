package main.study.algorithm.Tree;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 */
public class BinaryTreePostorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) return result;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            curr = stack.pop();
            result.addFirst(curr.val);
            if(curr.left != null)
                stack.push(curr.left);
            if(curr.right != null)
                stack.push(curr.right);
        }
        return result;
    }

    public List<Integer> postorderTraversal_recursion(TreeNode root) {

        List<Integer> rst = new ArrayList<>();
        helper(root, rst);

        return rst;

    }

    private void helper(TreeNode root, List<Integer> rst) {
        if (root == null) {
            return;
        }
        helper(root.left, rst);
        helper(root.right, rst);
        rst.add(root.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);
        root.right = right;
        right.left = rightLeft;

        BinaryTreePostorderTraversal_145 myObj = new BinaryTreePostorderTraversal_145();
        List<Integer> rst = myObj.postorderTraversal(root);
        System.out.println(Arrays.toString(rst.toArray()));
    }
}
