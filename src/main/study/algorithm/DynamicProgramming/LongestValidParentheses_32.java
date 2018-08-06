package main.study.algorithm.DynamicProgramming;

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

        /**
         * f[i][j]为true的情况是3种：
         * * ([True]) 头尾字符是对称的括号，中间也是
         * [i,k] [k+1,j]
         *
         */

        boolean[][] f = new boolean[n][n];
        for (int j = 1; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                if (s.charAt(i+j) == '(')
                    continue;
                if (j == 1 ){
                   if(s.charAt(i) == '(' && s.charAt(i+j) == ')') {
                        f[i][i+j] = true;
                }

                } else {
                    if (f[i][i+1] && f[i+2][i+j]) {
                        f[i][i+j] = true;
                    }
                    if (f[i][i+j-2] && f[i+j-1][i+j]) {
                        f[i][i+j] = true;
                    }
                    if (f[i+1][i+j-1] && s.charAt(i) == '(' && s.charAt(i+j) == ')') {
                        f[i][i+j] = true;
                    }

                }

                if (f[i][i+j]) {
                    max = Math.max(max, j+1);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "(()";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);

    }

}
