package test.study.algorithm.LinkedList;

import main.study.algorithm.LinkedList.AddTwoNumbers_2;
import main.study.algorithm.LinkedList.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbers_2Test {

    @Test
    void addTwoNumbers() {

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        AddTwoNumbers_2 myObj = new AddTwoNumbers_2();
        ListNode rst = myObj.addTwoNumbers(a1, b1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }

    @Test
    void addTwoNumbers2() {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(8);

        a1.next = a2;


        ListNode b1 = new ListNode(0);

        AddTwoNumbers_2 myObj = new AddTwoNumbers_2();
        ListNode rst = myObj.addTwoNumbers(a1, b1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }

    @Test
    void addTwoNumbers3() {

        ListNode a1 = new ListNode(5);

        ListNode b1 = new ListNode(5);

        AddTwoNumbers_2 myObj = new AddTwoNumbers_2();
        ListNode rst = myObj.addTwoNumbers(a1, b1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }

    @Test
    void addTwoNumbers4() {

        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(7);

        a1.next = a2;

        ListNode b1 = new ListNode(9);
        ListNode b2 = new ListNode(2);

        b1.next = b2;

        AddTwoNumbers_2 myObj = new AddTwoNumbers_2();
        ListNode rst = myObj.addTwoNumbers(a1, b1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }
}