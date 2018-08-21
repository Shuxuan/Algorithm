package main.study.algorithm.Sort;

import main.study.algorithm.LinkedList.ListNode;
import main.study.algorithm.LinkedList.Util;

/**
 * https://leetcode.com/problems/insertion-sort-list/description/
 *
 * Sort a linked list using insertion sort.
 *
 *
 * A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 * With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 *
 *
 * Algorithm of Insertion Sort:
 *
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 */
public class InsertionSortList_147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            // insert cur into helper
            // save next of cur first
            ListNode next = cur.next;
            cur.next = null;

            ListNode pre = helper;
            ListNode node = pre.next;
            while (node != null) {
                if (cur.val < node.val) {
                    //insert cur before node
                    pre.next = cur;
                    cur.next = node;
                    break;
                }
                pre = node;
                node = node.next;

            }
            if (node == null) {
                pre.next = cur;
            }

            cur = next;
        }

        return helper.next;

    }

    public static void main(String[] args) {
        int[] nums = {4,2,1,3};
        ListNode head = Util.createList(nums);

        InsertionSortList_147 myObj = new InsertionSortList_147();
        ListNode rst = myObj.insertionSortList(head);
        Util.printList(rst);

    }

}
