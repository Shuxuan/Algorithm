package main.company.amazon;

import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        StringBuffer sb = new StringBuffer();

        int l = 0;
        int r = 0;

        String res = "";
        if (t == null || t.isEmpty() || s == null || s.isEmpty() || t.length() > s.length()) {
            return res;
        }
        char[] chs = t.toCharArray();
        Map<Character, Integer> toFind = new HashMap<>();
        Map<Character, Integer> found = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            toFind.put(ch, toFind.getOrDefault(ch, 0) + 1);
        }

        int required = toFind.size();
        int formed = 0;


        int min = Integer.MAX_VALUE;
        while (l < s.length() && r < s.length()) {
            char curr = s.charAt(r);
            sb.append(curr);
            if (toFind.containsKey(curr)) {
                found.put(curr, found.getOrDefault(curr, 0) + 1);
                if (found.get(curr) == toFind.get(curr))
                    formed++;
            }

            while (l <= r && required == formed) {
                if (r - l + 1 < min) {
                    min = sb.length();
                    res = sb.toString();
                }

                if (sb.length() > 0) {
                    char ch = sb.charAt(0);
                    sb.deleteCharAt(0);
                    if (found.containsKey(ch)) {
                        int count = found.get(ch);
                        count--;

                        found.put(ch, count);
                        if (found.get(ch) < toFind.get(ch))
                            formed--;



                    }
                    l++;
                }
            }
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ABCDDDDDDEEAFFBC";
        String t = "AFBC";

        MinimumWindowSubstring myObj = new MinimumWindowSubstring();
        String res = myObj.minWindow(s, t);
        System.out.println(res);
    }

}
