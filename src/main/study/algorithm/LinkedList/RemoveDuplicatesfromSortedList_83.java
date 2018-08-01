package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        while (pre != null && cur != null) {
            while (cur!= null && cur.val == pre.val) {
                cur = cur.next;
            }

            pre.next = cur;
            if (cur != null) {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);

        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        RemoveDuplicatesfromSortedList_83 myObj = new RemoveDuplicatesfromSortedList_83();
        ListNode rst = myObj.deleteDuplicates(a1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(1);
        ListNode b3 = new ListNode(2);
        ListNode b4 = new ListNode(3);
        ListNode b5 = new ListNode(3);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode rst2 = myObj.deleteDuplicates(b1);
        while (rst2 != null) {
            System.out.println(rst2.val);
            rst2 = rst2.next;
        }
    }

}
