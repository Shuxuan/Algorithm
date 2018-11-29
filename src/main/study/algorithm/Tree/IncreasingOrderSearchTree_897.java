package main.study.algorithm.Tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 *
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *  Note:
 *
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 */
public class IncreasingOrderSearchTree_897 {


    TreeNode prev = null;
    TreeNode head = null;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        increasingBST(root.left);
        if (prev != null) {
            prev.right = root;
            root.left = null;
        }

        if (head == null)
            head = root;
        prev = root;
        increasingBST(root.right);

        return head;
    }


    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode cur = root;
        TreeNode helper = new TreeNode(0);
        TreeNode prev = helper;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();

            prev.right = cur;
            prev.left = null;
            prev = cur;
            cur = cur.right;


        }

        return helper.right;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n2.left = n1;
        n2.right = n3;

        IncreasingOrderSearchTree_897 myObj = new IncreasingOrderSearchTree_897();
        TreeNode rst = myObj.increasingBST(n2);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.right;
        }


    }
}
