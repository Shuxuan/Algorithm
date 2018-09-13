package main.study.algorithm.Tree;

import java.util.*;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeinBinarySearchTree_501 {

    /**
     * 见到BST就想到中序遍历。这个题中的BST是可以包含相同的元素的，题目的要求就是找出相同的元素出现次数最多的是哪几个。
     * 那么就可以先进行中序遍历得到有序的排列，如果两个相邻的元素相同，那么这个就是连续的，找出连续最多的即可。
     * 题目思路就是BST的中序遍历加上最长连续相同子序列。
     *
     * 题目建议不要用附加空间hash等，方法是计算了两次，一次是统计最大的模式出现的次数，第二次的时候构建出来了数组，然后把出现次数等于最大模式次数的数字放到数组的对应位置。
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }

    private void inorder(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleValue(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleValue(node.val);
                    node = node.right;
                }
            }
        }
    }
    private void inorder2(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        root.right = n2;
        //n2.left = n3;

        FindModeinBinarySearchTree_501 myObj = new FindModeinBinarySearchTree_501();
        System.out.println(Arrays.toString(myObj.findMode(root)));
    }

}
