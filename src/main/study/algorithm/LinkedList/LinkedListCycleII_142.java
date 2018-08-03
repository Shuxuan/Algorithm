package main.study.algorithm.LinkedList;

/**
 *
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * 找到环的入口结点。这是链表问题中的一个经典问题。
 *
 * 比较简单的方法，是先用快慢双指针找到重合位置。然后慢指针从头开始，和快指针 均采用一步速开始遍历，重合位置为环的入口结点。
 *
 */
public class LinkedListCycleII_142 {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;

            if (walker == runner)
                break;
        }

        if (walker == runner) {
            walker = head;
            while (walker != runner) {
                walker = walker.next;
                runner = runner.next;
            }

            return runner;
        }


        return null;
    }

}
