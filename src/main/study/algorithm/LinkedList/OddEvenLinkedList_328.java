package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        /**
         * 遍历， odd一队， even一队，然后 even接到odd尾部
         */

        boolean odd = true;

        ListNode cur = head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenHead2 = evenHead;
        while (cur != null) {
            ListNode next = cur.next;
            if (odd) {
                oddHead.next = cur;
                oddHead = cur;
            } else {
                evenHead.next = cur;
                evenHead = cur;
            }
            odd = !odd;
            cur = next;
        }
        evenHead.next = null;
        oddHead.next = evenHead2;

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = Util.createList(nums);

        OddEvenLinkedList_328 myObj = new OddEvenLinkedList_328();
        ListNode rst = myObj.oddEvenList(head);
        Util.printList(rst);

    }
}
