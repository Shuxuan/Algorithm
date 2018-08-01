package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesfromSortedListII_82 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
            } else {
                while (cur.next!= null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }

        }

        return helper.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(1);
        ListNode a4 = new ListNode(2);
        ListNode a5 = new ListNode(3);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        RemoveDuplicatesfromSortedListII_82 myObj = new RemoveDuplicatesfromSortedListII_82();
        ListNode rst = myObj.deleteDuplicates(a1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }



    }
}
