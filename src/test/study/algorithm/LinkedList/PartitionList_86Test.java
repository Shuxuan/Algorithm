package test.study.algorithm.LinkedList;

import main.study.algorithm.LinkedList.ListNode;
import main.study.algorithm.LinkedList.PartitionList_86;
import main.study.algorithm.LinkedList.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionList_86Test {

    @Test
    void partition1() {
        int[] nums = {1,4,3,2,5,2};
        ListNode head = Util.createList(nums);
        PartitionList_86 myObj = new PartitionList_86();

        ListNode rst = myObj.partition(head, 3);

        Util.printList(rst);
    }

    @Test
    void partition2() {
        int[] nums = {3,1,2};
        ListNode head = Util.createList(nums);
        PartitionList_86 myObj = new PartitionList_86();

        ListNode rst = myObj.partition(head, 3);

        Util.printList(rst);
    }
}