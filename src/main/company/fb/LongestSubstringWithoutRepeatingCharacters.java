package main.company.fb;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int rst = 0;
        if (s == null || s.isEmpty()) {
            return rst;
        }
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                start = Math.max(start, map.get(c) + 1);
                map.put(c, i);
            }
            rst = Math.max(rst, i - start + 1);
        }

        return rst;
    }

}
