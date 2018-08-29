package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreetoLinkedList_114_preorder {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        if (prev != null ) {
            prev.right = root;
        }
        prev = root;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        flatten(left);
        flatten(right);


    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        FlattenBinaryTreetoLinkedList_114_preorder myObj = new FlattenBinaryTreetoLinkedList_114_preorder();
        myObj.flatten(node1);
    }

}
