package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList_234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMiddle(head);

        ListNode l1 = head;
        ListNode l2 = mid.next;

        mid.next = null; // 断开
        ListNode l2Reverse = reverse(l2);


        while (l1 != null && l2Reverse != null) {

            if (l1.val != l2Reverse.val) {
                return false;
            }
            l1 = l1.next;
            l2Reverse = l2Reverse.next;
        }



        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head.next;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        return walker;
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
        int[] nums = {1,2,2,1};//{1,2,3,2,1};
        ListNode list = Util.createList(nums);

        PalindromeLinkedList_234 myObj = new PalindromeLinkedList_234();
        boolean rst = myObj.isPalindrome(list);

        System.out.println(rst);


    }
}
