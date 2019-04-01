package main.company.vmw;

import main.study.algorithm.LinkedList.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(-1);
        ListNode newHead = helper;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                helper.next = l1;
                l1 = l1.next;
            } else {
                helper.next = l2;
                l2 = l2.next;
            }

            helper = helper.next;

        }

        while (l1 != null) {
            helper.next = l1;
            l1 = l1.next;
            helper = helper.next;
        }

        while ((l2 != null)) {
            helper.next = l2;
            l2 = l2.next;
            helper = helper.next;
        }

        return newHead.next;
    }



}
