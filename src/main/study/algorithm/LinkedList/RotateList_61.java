package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/rotate-list/description/
 *
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int lenth = 0;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode cur = head;
        while (cur != null) {
            lenth++;
            cur = cur.next;
        }

        k = k % lenth;



        ListNode runner = head;
        int i = 1;
        while (i <= k) {
            runner = runner.next;
            i++;
        }

        ListNode walker = head;

        while (runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }

        runner.next = head;
        helper.next = walker.next;
        walker.next = null;


        return helper.next;
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

        RotateList_61 myObj = new RotateList_61();
        ListNode rst = myObj.rotateRight(a1, 2);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }

    }
}
