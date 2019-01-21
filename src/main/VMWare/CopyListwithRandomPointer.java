package main.VMWare;

import main.study.algorithm.Tree.RandomListNode;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode start = head;
        while (start != null) {
            RandomListNode newStart = new RandomListNode(start.label);
            map.put(start, newStart);
            start = start.next;
        }

        start = head;
        while (start != null) {

            RandomListNode newStart = map.get(start);
            newStart.next = map.get(start.next);
            newStart.random = map.get(start.random);
            start = start.next;
        }

        return map.get(head);
    }

}
