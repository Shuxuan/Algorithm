package main.company.vmw;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> item = new ArrayList<>();
                item.add(str);
                map.put(key, item);
            }
        }

        List<List<String>> rst = new ArrayList<>();
        for (List<String> item : map.values()) {
            rst.add(item);
        }

        return rst;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams myTest = new GroupAnagrams();
        myTest.groupAnagrams(strs);
    }
}
