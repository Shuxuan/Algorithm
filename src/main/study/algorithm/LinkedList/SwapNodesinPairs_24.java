package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 *
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class SwapNodesinPairs_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = head;
        while (pre != null && pre.next != null) {

        }
    }

}
