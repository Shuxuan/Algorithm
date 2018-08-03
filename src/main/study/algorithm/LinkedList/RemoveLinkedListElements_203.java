package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements_203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                ListNode next = cur.next;
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }

        }

        return helper.next;
    }
}
