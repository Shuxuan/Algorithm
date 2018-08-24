package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstruBinaryTreefromPreorderandInorderTraversal_105 {
    /**
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // preorder : get root
        // inorder: get left child and right child

        if (preorder == null || inorder == null) {
            return null;
        }

        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int startp, int endp, int[] inorder, int starti, int endi) {
        if (startp > endp || starti > endi)
            return null;
        TreeNode root = new TreeNode(preorder[startp]);
        int indexi = starti;
        //indexi is the root position in inorder
        while (inorder[indexi] != root.val) {
            indexi++;
        }

        // inorder:
        // [starti TO indexi-1], is the left child range
        // left child count: indexi - starti
        // [indexi + 1 TO endi],   is the right child range
        // right child count: endi - indexi

        // preorder:
        // [startp + 1 TO startp  + indexi - starti] is the left child range
        // [startp  + indexi - starti + 1 TO endp]   is the right child range

        TreeNode left = helper(preorder, startp + 1, startp  + indexi - starti, inorder, starti, indexi-1);
        TreeNode right = helper(preorder, startp  + indexi - starti + 1, endp, inorder, indexi + 1, endi);
        root.left = left;
        root.right = right;

        return root;

    }

}
