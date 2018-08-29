package main.study.algorithm.Tree;

import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
 *
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 *
 * Given the following perfect binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersinEachNode_116_TwoStacks {

    public void connect(TreeLinkNode root) {
        /**
         * two stacks. one is updating the next link
         * the other is to store the next level elements
         */

        if (root == null) {
            return;
        }

        Stack<TreeLinkNode> stack = new Stack<>();
        stack.push(root);

        Stack<TreeLinkNode> stack2 = new Stack<>();
        while (!stack.isEmpty() || !stack2.isEmpty()) {

            while (!stack.isEmpty()) {
                TreeLinkNode cur = stack.pop();
                if (!stack.isEmpty()) {
                    cur.next = stack.peek();
                }

                if (cur.left != null) {
                    stack2.push(cur.left);
                }

                if (cur.right != null) {
                    stack2.push(cur.right);
                }
            }

            // move stack2 element to stack1
            while (!stack2.isEmpty())
                stack.push(stack2.pop());

        }


    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        n1.left = n2;
        n1.right = n3;

        PopulatingNextRightPointersinEachNode_116_TwoStacks myObj = new PopulatingNextRightPointersinEachNode_116_TwoStacks();
        myObj.connect(n1);
    }

}
