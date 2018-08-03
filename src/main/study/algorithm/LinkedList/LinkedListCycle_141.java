package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        boolean rst = false;

        if (head == null || head.next == null) {
            return rst;
        }

        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (walker == runner) {
                return true;
            }

        }


        return rst;
    }
}
