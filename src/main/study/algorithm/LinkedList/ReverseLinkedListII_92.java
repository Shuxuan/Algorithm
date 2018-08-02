package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;


        int i = 1;

        while (i < m) {
            pre = pre.next;
            i++;
        }

        ListNode nodeM = pre.next;

        ListNode nodeN = this.reverseK(nodeM, n - m);
        pre.next = nodeN;

        return helper.next;
    }

    public ListNode reverseK(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        int i = 0;
        while (i <= k && cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            i++;
        }

        head.next = cur;

        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = Util.createList(nums);
        ReverseLinkedListII_92 myObj = new ReverseLinkedListII_92();
        ListNode rst = myObj.reverseBetween(head, 2, 4);
        Util.printList(rst);

    }
}
