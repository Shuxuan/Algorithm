package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesinKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;

        while (pre != null) {
            pre = reverseK(pre, k);
        }


        return helper.next;

    }

    // head -> n1 -> n2 ... nk -> nk+1
    // =>
    // head -> nk -> nk-1 .. n1 -> nk+1
    // return n1
    public ListNode reverseK(ListNode head, int k) {
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }

        if (nk == null)
            return null;

        //reverse
        ListNode n1 = head.next;
        ListNode nkPlus = nk.next;
        ListNode pre = null;
        ListNode cur = n1;
        int i = 0;
        while (i < k) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }

        head.next = nk;
        n1.next = nkPlus;

        return n1;

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

        ReverseNodesinKGroup_25 myObj = new ReverseNodesinKGroup_25();
        ListNode rst = myObj.reverseKGroup(a1, 2);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }

}
