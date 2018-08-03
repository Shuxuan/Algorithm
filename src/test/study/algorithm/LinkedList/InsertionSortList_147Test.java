package test.study.algorithm.LinkedList;

import main.study.algorithm.LinkedList.InsertionSortList_147;
import main.study.algorithm.LinkedList.ListNode;
import main.study.algorithm.LinkedList.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortList_147Test {

    @Test
    void insertionSortList1() {
        int[] nums = {4,2,1,3};
        ListNode head = Util.createList(nums);

        InsertionSortList_147 myObj = new InsertionSortList_147();
        ListNode rst = myObj.insertionSortList(head);
        Util.printList(rst);
    }

    @Test
    void insertionSortList2() {
        int[] nums = {-1,5,3,4,0};
        ListNode head = Util.createList(nums);

        InsertionSortList_147 myObj = new InsertionSortList_147();
        ListNode rst = myObj.insertionSortList(head);
        Util.printList(rst);
    }
}