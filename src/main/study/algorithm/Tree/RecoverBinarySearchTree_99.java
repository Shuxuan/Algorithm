package main.study.algorithm.Tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 *
 * Input: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * Output: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree_99 {

    public void recoverTree(TreeNode root) {
        //inorder traversal
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.println(root.val);
            if (pre != null && root.val<= pre.val) {
                if (first == null) {
                    first = pre;
                    second = root;
                }else {
                    second = root;
                    break;
                }
            }
            pre = root;
            root = root.right;

        }

        if (first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(3);
        root.left = left;
        TreeNode right = new TreeNode(2);
        left.right = right;

        RecoverBinarySearchTree_99 myObj = new RecoverBinarySearchTree_99();
        myObj.recoverTree(root);
    }
}
