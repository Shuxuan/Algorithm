package test.study.algorithm.LinkedList;

import main.study.algorithm.LinkedList.ListNode;
import main.study.algorithm.LinkedList.SplitLinkedListinParts_725;
import main.study.algorithm.LinkedList.Util;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SplitLinkedListinParts_725Test {

    @Test
    void splitListToParts1() {
        int[] nums = {1, 2, 3};
        ListNode root = Util.createList(nums);
        SplitLinkedListinParts_725 myObj = new SplitLinkedListinParts_725();
        ListNode[] rst = myObj.splitListToParts(root, 5);

        for (ListNode node : rst) {
            System.out.println("****************");
            Util.printList(node);
        }
    }

    @Test
    void splitListToParts2() {
        int[] nums = {1, 2, 3,4,5,6,7};
        ListNode root = Util.createList(nums);
        SplitLinkedListinParts_725 myObj = new SplitLinkedListinParts_725();
        ListNode[] rst = myObj.splitListToParts(root, 3);

        for (ListNode node : rst) {
            System.out.println("****************");
            Util.printList(node);
        }
    }
}