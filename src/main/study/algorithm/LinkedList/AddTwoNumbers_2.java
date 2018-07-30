package main.study.algorithm.LinkedList;

import java.util.List;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(0);

        if (l1 == null || l2 == null) {
            return rst;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;

        int carry = 0;
        ListNode head = rst;

        while (head1 != null && head2 != null) {
            int val = (head1.val + head2.val + carry) % 10;
            carry = (head1.val + head2.val + carry) / 10;
            ListNode cur = new ListNode(val);
            head.next = cur;
            head = cur;
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null) {
            int val = (head1.val + carry) % 10;
            carry = (head1.val + carry) / 10;
            ListNode cur = new ListNode(val);
            head.next = cur;
            head = cur;
            head1 = head1.next;
        }

        while (head2 != null) {
            int val = (head2.val + carry) % 10;
            carry = (head2.val + carry) / 10;
            ListNode cur = new ListNode(val);
            head.next = cur;
            head = cur;
            head2 = head2.next;
        }

        if (carry > 0) {
            ListNode cur = new ListNode(carry);
            head.next = cur;
        }

        return rst.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        AddTwoNumbers_2 myObj = new AddTwoNumbers_2();
        ListNode rst = myObj.addTwoNumbers(a1, b1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }


    }

}
