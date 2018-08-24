package main.study.algorithm.Tree;

import apple.laf.JRSUIUtils;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {

    /**
     *
     * @param inorder
     * @param postorder
     * @return
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /**
         * in postorder, end element is the root.
         * find root in inorder,
         * Inorder
         * start to root index -1 is the left child,
         * root index + 1 to end is the right child.
         *
         * postorder:
         * start to start + count-1 is the left child
         * start + count, to end - 1 is the right child
         */

        if (inorder == null || postorder == null) {
            return null;
        }

        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int starti, int endi, int[] postorder, int startp, int endp) {
        if (starti > endi || startp > endp) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[endp]);

        // find indexi of root in inorder
        int indexi = starti;
        while (inorder[indexi] != root.val) {
            indexi++;
        }

        // inorder
        // [starti TO indexi-1] is left child
        // count of left: indexi - starti

        // [indexi + 1 TO endi] is the right child
        // count of right: endi - indexi

        // postorder
        // [startp TO startp + indexi - starti - 1] is the left child
        // [ startp + indexi - starti TO endp - 1] is the right child

        TreeNode left = helper(inorder, starti, indexi-1, postorder, startp, startp + indexi - starti - 1);
        TreeNode right = helper(inorder, indexi + 1, endi, postorder, startp + indexi - starti, endp - 1);
        root.left = left;
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        ConstructBinaryTreefromInorderandPostorderTraversal_106 myObj = new ConstructBinaryTreefromInorderandPostorderTraversal_106();
        TreeNode root = myObj.buildTree(inorder, postorder);

    }

}
