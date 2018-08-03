package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/reorder-list/description/
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList_143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // find middle node
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            pre = pre.next;
            walker = walker.next;
            runner = runner.next.next;
        }

        pre.next = null;

        ListNode newHead = reverse(walker);

        merge(head, newHead);

    }

    private void merge(ListNode head1, ListNode head2) {
        while (head1 != null) {
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;

            head1.next = head2;
            if (next1 != null)
                head2.next = next1;

            head1 = next1;
            head2 = next2;
        }
        if (head2 != null) {

        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = Util.createList(nums);
        ReorderList_143 myObj = new ReorderList_143();
        myObj.reorderList(head);
        Util.printList(head);

    }

}
