package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class FlattenBinaryTreetoLinkedList_114_bruteforce {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flatten_preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        List<TreeNode> list = this.preorder(root);

        for (int i = 1; i < list.size(); i++) {
            TreeNode cur = list.get(i);
            TreeNode prev = list.get(i-1);
            prev.left = null;
            prev.right = cur;
        }
    }

    private List<TreeNode> preorder(TreeNode root) {
        List<TreeNode> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = cur;
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return rst;

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

        FlattenBinaryTreetoLinkedList_114_bruteforce myObj = new FlattenBinaryTreetoLinkedList_114_bruteforce();
        myObj.flatten(node1);
    }

}
