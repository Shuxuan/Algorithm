package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
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
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 *
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        /**
         * f[i][j] 代表s的第1到第i个字符， 和p的第1到第j个字符的match 结果
         *
         * f[0][0] s and p both empty string, f[0][0] = true;
         *
         * if （s[i] == p[j] || p[j] == '.'）, then f[i][j] = f[i-1][j-1], i， j start from 1，
         *
         * if p[j] == '*',
         * consider 0 occurrence, f[i][j] = f[i][j-2]
         * consider 1 or more occurence, if s[i] == p[j-1] || p[j-1] == '.', f[i][j] = f[i-1][j]
         *
         * else f[i][j] = false (default is false)
         */
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;


        /**
         * f[i][0] = false (i >= 1)
         * f[0][j] = false (j >= 1), if pattern is like a*b*c*, f[0][j] = true;
         */

        if (p.length() > 0 && p.length() % 2 == 0) {
            boolean starFlag = true;
            for (int i = 1; i < n+1; i = i + 2) {
                if (p.charAt(i) != '*')  {
                    starFlag = false;
                    break;
                }
            }

            if (starFlag) {
                for (int i = 1; i < n+1; i++) {
                    f[0][i] = true;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    f[i][j] = f[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                        f[i][j] = f[i-1][j];
                    } else {
                        f[i][j] = f[i][j-2];
                    }
                }
            }
        }

        return f[m][n];

    }

}
