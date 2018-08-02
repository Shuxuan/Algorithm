package main.study.algorithm.LinkedList;

/**
 * https://leetcode.com/problems/partition-list/description/
 *
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode helper = new ListNode(0);
        helper.next = head;

        /**
         *  1 find the first node which val >= x， insertPos
         *  后面符合条件的node都要插入到这个节点之后，
         */
        ListNode insertPos = helper;

        while (insertPos != null && insertPos.next != null && insertPos.next.val < x) {
            insertPos = insertPos.next;
        }

        if (insertPos == null) {
            return helper.next;
        }


        /**
         * 2 从partion位置往后遍历，
         *   寻找节点 (val < x),
         *   把这个节点插入pre和 partitionPos 之间
         *   更新pre
         *   更新cur
         */

        ListNode pre = insertPos.next;
        ListNode cur = null;
        while (pre != null) {
            cur = pre.next;
            if (cur != null && cur.val < x) {
                ListNode next = cur.next;
                pre.next = next;

                // insert cur after insertPos

                next = insertPos.next;
                insertPos.next = cur;
                cur.next = next;
                insertPos = insertPos.next;
            } else
                pre = pre.next;
        }

        return helper.next;

    }

    public static void main (String[] args) {
        int[] nums = {3,1,2};
        ListNode head = Util.createList(nums);
        PartitionList_86 myObj = new PartitionList_86();

        ListNode rst = myObj.partition(head, 3);

        Util.printList(rst);

        System.out.println("#############################");
        int[] nums1 = {1,4,3,2,5,2};
        ListNode head1 = Util.createList(nums1);
        ListNode rst1 = myObj.partition(head1, 3);
        Util.printList(rst1);
    }

}
