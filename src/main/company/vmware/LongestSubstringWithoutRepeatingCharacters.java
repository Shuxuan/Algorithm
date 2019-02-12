package main.company.vmware;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
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

    public static void main(String[] args) {
        //String input = "abcabcbb";
        String input = "abba";
        LongestSubstringWithoutRepeatingCharacters myTest = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(myTest.lengthOfLongestSubstring(input));
    }

}
