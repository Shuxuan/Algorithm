package main.study.algorithm.DynamicProgramming;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses_32 {

    public int longestValidParentheses(String s) {

        if (s == null || s.isEmpty() || s.length() == 1) {
            return 0;
        }

        int max = 0;
        int n = s.length();
        HashMap<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    int j = stack.pop();
                    if (map.containsKey(j-1)) {
                        int start = map.get(j-1);
                        map.put(i, start);
                        max = Math.max(max, i - start +1);

                    }else {
                        map.put(i, j);
                        max = Math.max(max, i - j +1);

                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "(()()(())((";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);

    }

}
