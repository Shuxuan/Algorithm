package main.study.algorithm.DynamicProgramming;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/scramble-string/description/
 *
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * Example 1:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 */
public class ScrambleString_87 {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int len = 2; len <= s1.length(); len++) {
            for (int i = 0; i < s1.length() - len + 1; i++) {
                for (int j = 0; j < s2.length() - len + 1; j++) {
                    for (int k = 1; k < len; k++) {
                        dp[i][j][len] |= dp[i][j][k] && dp[i + k][j + k][len - k] || dp[i][j + len - k][k] && dp[i + k][j][len - k];
                    }
                }
            }
        }

        return dp[0][0][s1.length()];
    }

        public boolean isScramble_recursion(String s1, String s2) {
        /**
         *
         * 把s1，s2各自分成俩个substring, s11, s12, s21,s22,
         * (s11,s21) AND (s12, s22）为scramble string
         * 或者
         * (s11, S22) AND (s12, S21) 为scramble string
         */
        boolean rst = false;
        if (s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i+1), s2.substring(0, i+1)) && isScramble(s1.substring(i+1, s1.length()), s2.substring(i+1, s1.length()) ))
                return true;
            if (isScramble(s1.substring(0,i+1), s2.substring(s1.length()-i-1)) && isScramble(s1.substring(i+1, s1.length()), s2.substring(0,i+1)))
                return true;
        }

        return false;

    }



    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";

        ScrambleString_87 myObj = new ScrambleString_87();
        boolean rst = myObj.isScramble(s1, s2);
        System.out.println(rst);
    }
}
