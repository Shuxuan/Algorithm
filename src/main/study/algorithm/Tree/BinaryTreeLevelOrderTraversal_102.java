package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> rst = new ArrayList<>();

        if (root == null) {
            return rst;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            List<Integer> list = new ArrayList<>();
            while(!stack1.isEmpty()) {

                TreeNode cur = stack1.pop();
                list.add(cur.val);
                if (cur.left != null)
                    stack2.push(cur.left);
                if (cur.right != null)
                    stack2.push(cur.right);

            }

            rst.add(list);

        }

        return rst;

    }
}
