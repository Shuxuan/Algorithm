package main.company.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class LRUCache {
    class Node{
        int key, val;
        Node prev, next;
        Node(){
            this.key = 0;
            this.val = 0;
        }

        Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }


    Map<Integer, Node> map;
    Node head, tail;
    int count;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        count = 0;
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node temp = map.get(key);
        if(temp == null){
            return -1;
        }
        else{
            int res = temp.val;
            update(temp);
            return res;
        }
    }

    public void put(int key, int value) {
        Node temp = map.get(key);
        if(temp == null){
            Node node = new Node(key, value);
            map.put(key, node);
            count++;
            add(node);
        }
        else{
            temp.val = value;
            update(temp);
        }
        if(count > capacity){
            Node toDelete = tail.prev;
            int k = toDelete.key;
            remove(toDelete);
            map.remove(k);
            count--;
        }
    }

    public void update(Node node){
        remove(node);
        add(node);
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void add(Node node){
        Node next = head.next;
        node.prev = head;
        head.next = node;
        node.next = next;
        next.prev = node;
    }
}