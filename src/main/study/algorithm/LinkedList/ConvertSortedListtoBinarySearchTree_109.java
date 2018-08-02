package main.study.algorithm.LinkedList;

import main.study.algorithm.Tree.TreeNode;

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

        return null;

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
    public TreeNode helper(ListNode head, int l, int r) {
        if (head == null || head.next == null) {
            return new TreeNode(head.val);
        }



        return null;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        ListNode head = Util.createList(nums);
        ConvertSortedListtoBinarySearchTree_109 myObj = new ConvertSortedListtoBinarySearchTree_109();
        int lenth = myObj.lenth(head);
        System.out.println(lenth);
    }

}
