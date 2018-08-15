package main.study.algorithm.DynamicProgramming;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: "cbacdcbc"
 * Output: "acdb"
 */
public class RemoveDuplicateLetters_316 {

    public String removeDuplicateLetters(String s) {
        /**
         * find duplicated characters.
         */
        if (s == null || s.isEmpty()) {
            return s;
        }


        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a'] = count[c-'a'] +1;
        }
        int len = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                len++;
            }
        }

        int drop = s.length() - len;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!stack.isEmpty() && stack.contains(c)) {
                drop--;
                count[c - 'a'] = count[c-'a'] - 1;
                continue;
            }
            while (!stack.isEmpty() && drop > 0 && stack.peek() - c >= 0 && count[stack.peek() - 'a'] > 1) {
                drop--;
                count[stack.peek() - 'a'] = count[stack.peek() - 'a'] - 1;
                stack.pop();
            }
            stack.push(c);

        }



        char[] rst = new char[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            rst[index--] = stack.pop();

        }


        return String.copyValueOf(rst);
    }

    public static void main(String[] args) {
        //String s = "bcabc";
        //String s = "cbacdcbc";
        String s = "ccacbaba";
        RemoveDuplicateLetters_316 myObj = new RemoveDuplicateLetters_316();
        String rst = myObj.removeDuplicateLetters(s);

        System.out.println(rst);
    }

}
