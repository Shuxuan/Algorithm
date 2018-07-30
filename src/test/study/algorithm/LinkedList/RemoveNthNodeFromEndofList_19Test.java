package test.study.algorithm.LinkedList;

import main.study.algorithm.LinkedList.ListNode;
import main.study.algorithm.LinkedList.RemoveNthNodeFromEndofList_19;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndofList_19Test {

    @Test
    void removeNthFromEnd() {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        RemoveNthNodeFromEndofList_19 myObj = new RemoveNthNodeFromEndofList_19();
        ListNode rst = myObj.removeNthFromEnd(a1, 2);
        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }

    @Test
    void removeNthFromEnd2() {

        System.out.println("*********************");
        ListNode a1 = new ListNode(1);


        RemoveNthNodeFromEndofList_19 myObj = new RemoveNthNodeFromEndofList_19();
        ListNode rst = myObj.removeNthFromEnd(a1, 1);
        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }
}