package main.study.algorithm.LinkedList;

public class Util {
    public static ListNode createList(int[] nums) {
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        for (int item : nums) {
            ListNode cur = new ListNode(item);
            pre.next = cur;
            pre = cur;

        }

        return helper.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};
        ListNode rst = Util.createList(nums);

        Util.printList(rst);
    }
}
