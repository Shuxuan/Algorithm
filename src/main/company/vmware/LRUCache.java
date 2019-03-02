package main.company.vmware;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
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
 * LRUCache_LinkedHashMap cache = new LRUCache_LinkedHashMap( 2  );// capacity
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {


    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node() {
            this.key = 0;
            this.val = 0;
        }

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    int capacity;
    int count;
    Node tail;
    Node head;

    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }

        this.capacity = capacity;
        count = 0;
        head = new Node();
        tail = new Node();
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        int res = node.val;
        update(node);
        return res;
    }


    public void put(int key, int value) {
        Node temp = map.get(key);
        if (temp == null) {
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
            count++;
        } else {
            temp.val = value;
            update(temp);
        }

        if (count > capacity) {
            // evict the eldest one
            Node toDelete = tail.prev;
            int k = toDelete.key;
            map.remove(k);
            remove(toDelete);
            count--;
        }

    }

    private void update(Node node) {
        //remove node
        remove(node);
        //add node to head.next
        add(node);
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

    }

    private void add(Node node) {
        // add node to head.next
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }
    public static void main(String[] args) {

    }
}
