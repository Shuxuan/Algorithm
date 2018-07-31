package main.study.algorithm.LinkedList;

import main.study.algorithm.Array.MergeSortedArray_88;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        helper.next = l1;

        //以L1为基准，把L2插入到l1的适当位置
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) {
                //把l2 插入到pre和l1之间
                //现保存l2。next
                ListNode next = l2.next;
                l2.next = l1;
                pre.next = l2;
                l2 = next;
            } else {
                l1 = l1.next;
            }
            pre = pre.next;

        }



        if (l2 != null) {
            pre.next = l2;
        }

        return helper.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;

        MergeTwoSortedLists_21 myObj = new MergeTwoSortedLists_21();
        ListNode rst = myObj.mergeTwoLists(a1, b1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }

    }

}
