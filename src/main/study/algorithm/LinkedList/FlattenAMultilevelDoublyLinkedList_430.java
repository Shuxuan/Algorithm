package main.study.algorithm.LinkedList;

import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
 *
 * ou are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 * Example:
 *
 * Input:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 * Explanation for the above example:
 *
 * Given the following multilevel doubly linked list:
 *
 *
 *
 * We should return the following flattened doubly linked list:
 */
public class FlattenAMultilevelDoublyLinkedList_430 {
    public Node flatten(Node head) {
        if( head == null) return head;
        // Pointer
        Node cur = head;
        while( cur!= null) {
            /* CASE 1: if no child, proceed */
            if( cur.child == null ) {
                cur = cur.next;
            } else {
                /* CASE 2: got child, find the tail of the child and link it to p.next */
                Node temp = cur.child;
                // Find the tail of the child
                while (temp.next != null)
                    temp = temp.next;
                // Connect tail with p.next, if it is not null
                temp.next = cur.next;
                if (cur.next != null) cur.next.prev = temp;
                // Connect p with p.child, and remove p.child
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
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
}
