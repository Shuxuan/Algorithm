package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    List<TreeNode> list = new ArrayList<>();
    int index = 0;
    public BSTIterator(TreeNode root) {
        inOrder(root);

    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        list.add(root);
        inOrder(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size()? true : false;

    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++).val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */