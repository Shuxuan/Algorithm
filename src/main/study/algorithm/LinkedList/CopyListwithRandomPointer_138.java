package main.study.algorithm.LinkedList;

import main.study.algorithm.Tree.RandomListNode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */
public class CopyListwithRandomPointer_138 {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode helper = head;
        while (head != null) {
            RandomListNode cur = null;
            if (!map.containsKey(head)) {
                cur = new RandomListNode(head.label);
                map.put(head, cur);
            }

            cur = map.get(head);


            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    RandomListNode next = new RandomListNode(head.next.label);
                    map.put(head.next, next);
                }

                cur.next = map.get(head.next);
            }

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    RandomListNode random = new RandomListNode(head.random.label);
                    map.put(head.random, random);
                }

                cur.random = map.get(head.random);
            }

            head = head.next;
        }

        return map.get(helper);
    }

    public static void main(String[] args) {
        RandomListNode a1 = new RandomListNode(1);
        System.out.println(a1);
        CopyListwithRandomPointer_138 myObj = new CopyListwithRandomPointer_138();
        RandomListNode rst = myObj.copyRandomList(a1);

        while (rst != null) {
            System.out.println(rst);
            System.out.println("***********");
            System.out.println("lablel: " + rst.label);

            System.out.println("next: " + (rst.next == null ? "null" : rst.next.label));

            System.out.println("random: " + (rst.random == null ? "null" : rst.random.label));

            rst = rst.next;
        }
    }
}
