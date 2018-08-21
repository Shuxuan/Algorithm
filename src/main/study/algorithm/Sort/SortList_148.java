package main.study.algorithm.Sort;

import main.study.algorithm.LinkedList.ListNode;

/**
 * https://leetcode.com/problems/sort-list/description/
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class SortList_148 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode head2 = middle.next;
        middle.next = null; //断开

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head2);

        return merge(l1, l2);


    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else  {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        cur.next = null;
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }

    /**
     * 利用快慢指针找到中间节点
     * @param head
     */
    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode walker = head;
        ListNode runner = head.next;
        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        return walker;

    }



}
