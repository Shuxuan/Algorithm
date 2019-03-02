package main.company.vmware;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
public class LRUCache_LinkedHashMap {

    private int maxSize;
    LinkedHashMap<Integer, Integer> map;




    public LRUCache_LinkedHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        this.maxSize = capacity;

        //初始化LinkedHashMap。
        //第一个参数是初始容量
        //第二个参数是填装因子，或叫加载因子
        //第三个参数是排序模式，true表示在访问的时候进行排序，否则只在插入的时候才排序。
        this.map = new LinkedHashMap<Integer, Integer>(0, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > maxSize;
            }
        };


    };



    public int get(int key) {
        // get the value

        if (map.containsKey(key)) {
            int value = map.get(key);
            map.put(key, value); // update the least recent used list key
            return value;


        }

        return -1;

    }

    public void put(int key, int value) {
        map.put(key,value);

    }
}
