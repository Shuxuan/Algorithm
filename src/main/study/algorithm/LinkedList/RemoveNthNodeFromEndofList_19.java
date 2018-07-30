package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 */
public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode runner = head;
        int i = 0;
        while (runner != null && i < n) {
            runner = runner.next;
            i++;
        }
        if (runner == null)
            return head.next;
        if (i < n)
            return head;
        ListNode walker = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }

        walker.next = walker.next.next;

        return head;

    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        RemoveNthNodeFromEndofList_19 myObj = new RemoveNthNodeFromEndofList_19();
        ListNode rst = myObj.removeNthFromEnd(a1, 2);
        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }
}
