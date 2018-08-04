package test.study.algorithm.LinkedList;

import main.study.algorithm.LinkedList.FlattenAMultilevelDoublyLinkedList_430;
import main.study.algorithm.LinkedList.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlattenAMultilevelDoublyLinkedList_430Test {

    @Test
    void flatten() {
        Node a1 = new Node(1, null,null,null);
        Node a2 = new Node(2, a1, null, null);
        Node a3 = new Node(3, a2, null, null);
        Node a4 = new Node(4, a3, null, null);
        Node a5 = new Node(5, a4, null, null);
        Node a6 = new Node(6, a5, null, null);
        Node a7 = new Node(7, a3, null, null);
        Node a8 = new Node(8, a7, null, null);
        Node a9 = new Node(9, a8, null, null);
        Node a10 = new Node(10, a9, null, null);
        Node a11 = new Node(11, a8, null, null);
        Node a12 = new Node(12, a11, null, null);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

        a3.child = a7;
        a7.next = a8;
        a8.next = a9;
        a9.next = a10;

        a11.next = a12;

        a8.child = a11;

        FlattenAMultilevelDoublyLinkedList_430 myObj = new FlattenAMultilevelDoublyLinkedList_430();

        Node rst = myObj.flatten(a1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }

    @Test
    void flatten2() {
        Node a1 = new Node(1, null,null,null);
        Node a2 = new Node(2, null, null, null);
        Node a3 = new Node(3, null, null, null);
        Node a4 = new Node(4, null, null, null);
        Node a5 = new Node(5, null, null, null);
        Node a6 = new Node(6, null, null, null);
        Node a7 = new Node(7, null, null, null);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a6.next = a7;

        a2.child = a6;
        a3.child = a5;


        FlattenAMultilevelDoublyLinkedList_430 myObj = new FlattenAMultilevelDoublyLinkedList_430();

        Node rst = myObj.flatten(a1);

        while (rst != null) {
            System.out.println(rst.val);
            rst = rst.next;
        }
    }
}