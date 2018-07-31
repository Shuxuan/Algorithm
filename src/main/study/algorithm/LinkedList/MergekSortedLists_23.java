package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergekSortedLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return helper(lists, 0, lists.length-1);

    }

    public ListNode helper(ListNode[] lists, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            return mergeTwoLists(helper(lists, left, mid), helper(lists, mid+1, right));
        }

        return lists[left];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode helper = new ListNode(0);
        helper.next = l1;
        ListNode pre = helper;

        //以L1为基准，比L1小的，插入Pre和L1之间，否则L1后移
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) {
                //insert l2 between pre and l1
                ListNode next = l2.next;
                l2.next = pre.next;
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
}
