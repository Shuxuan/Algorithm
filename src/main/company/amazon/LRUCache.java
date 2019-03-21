package main.company.amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 capacity );

        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);       // returns 1
        cache.put(3,3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4,4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 */
public class LRUCache {

    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, LinkedNode> map;
    LinkedNode head;
    LinkedNode tail;
    private int capacity;
    int count = 0;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity is less or equal 0");
        }

        this.capacity = capacity;

        map = new HashMap<>();

        head = new LinkedNode(0, 0);
        tail = new LinkedNode(0,0);
        head.next = tail;
        tail.prev = head;


    }

    public int get(int key) {
        if (map.containsKey(key)) {

            LinkedNode curr = map.get(key);

            //remove the node to the list
            LinkedNode prev = curr.prev;
            LinkedNode next = curr.next;
            prev.next = next;
            next.prev = prev;

            // move the curr to the head
            LinkedNode tmp = head.next;
            head.next = curr;
            curr.next = tmp;
            tmp.prev = curr;
            curr.prev = head;

            return map.get(key).value;
        }

        throw new NoSuchElementException("no key " + key + " available" );
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //update value
            LinkedNode curr = map.get(key);
            curr.value = value;

            remove(curr);
            add(curr);

        } else {
            LinkedNode curr = new LinkedNode(key, value);

            if (count == capacity) {
                //remove tail
                remove(tail.prev);
                map.remove(key);
                count--;

            }

            map.put(key, curr);
            add(curr);
            count++;
        }


    }

    private void remove(LinkedNode node) {
        LinkedNode prev = node.prev;
        LinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void add(LinkedNode node) {
        LinkedNode tmp = head.next;
        head.next = node;
        node.next = tmp;
        tmp.prev = node;
        node.prev = head;
    }

}
