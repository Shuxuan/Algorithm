package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
 *
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * This tree is also valid:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 */
public class InsertintoaBinarySearchTree_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode insert = new TreeNode(val);
        if (root == null) {
            root = insert;
            return root;
        }

        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null) {
            pre = cur;
            if (cur.val < val)
                cur = cur.right;
            else
                cur = cur.left;
        }

        if (pre.val < val) {
            pre.right = insert;
        } else
            pre.left = insert;

        return root;

    }




}
