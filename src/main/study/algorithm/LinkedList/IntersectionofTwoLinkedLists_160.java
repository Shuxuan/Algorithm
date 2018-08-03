package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionofTwoLinkedLists_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 俩个节点分别从headA，headB开始走， 当走到尾时就从另外一个头开始接着走。最终相遇， 要么相遇在相交的地方，要么相交在N，结尾
         */

        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;

    }
}
