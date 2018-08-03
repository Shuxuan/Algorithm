package main.study.algorithm.LinkedList;

import main.study.algorithm.Tree.TreeNode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedListtoBinarySearchTree_109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        int lenth = lenth(head);
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        TreeNode root = helper(list, 0, lenth-1);

        return root;

    }

    private TreeNode helper(ArrayList<ListNode> list, int l, int r) {
        if (l > r)
            return null;
        int m = (l + r) / 2;
        TreeNode left = helper(list, l, m-1);
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = left;
        list.set(0,list.get(0).next);
        TreeNode right = helper(list, m+1, r);

        root.right = right;

        return root;
    }

    public int lenth(ListNode head) {
        int len = 0;
        ListNode helper = new ListNode(0);
        helper = head;
        while (helper != null) {
            len++;
            helper = helper.next;
        }
        return len;
    }


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        ListNode head = Util.createList(nums);
        ConvertSortedListtoBinarySearchTree_109 myObj = new ConvertSortedListtoBinarySearchTree_109();
        int lenth = myObj.lenth(head);
        System.out.println(lenth);
    }

}
