package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/wildcard-matching/description/
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class WildcardMatching_44 {

    public boolean isMatch(String s, String p) {

        if (s == null && p == null || s.isEmpty() && p.isEmpty()) {
            return true;
        }

        int m = s.length();
        int n = p.length();

        System.out.println("m = " + m + " n = " + n);

        boolean[][] df = new boolean[m+1][n+1];
        df[0][0] = true;

        if (!p.isEmpty()) {
            int i = 1;
            while (i <= n && p.charAt(i-1) == '*') {
                df[0][i] = df[0][i-1];
                i++;
            }
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    df[i][j] = df[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    df[i][j] = df[i][j-1] || df[i-1][j];
                }
            }
        }

        return df[m][n];

    }

    public static void main(String[] args) {
        String s = "ho";
        String p = "**ho";

        WildcardMatching_44 myObj = new WildcardMatching_44();

        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
    }
}
