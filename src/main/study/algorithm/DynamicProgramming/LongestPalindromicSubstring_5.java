package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s == null ) {
            return null;
        }
        if (s.isEmpty()) {
            return s;
        }
        int length = s.length();
        boolean[][] f = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            f[i][i] = true;
        }
        /**
         * if s.charAt[i] == charAt[j], 并且f【i+1】f【j-1】== true
         */
        int max = 1;
        String rst = s.substring(0,1);
        for (int i = length-1; i >= 0; i--) {
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j == i+1) {
                        f[i][j] = true;
                    }else {
                        f[i][j] = f[i+1][j-1];
                    }
                    if (f[i][j]) {
                        if (j - i + 1 > max) {
                            max = j-i + 1;
                            rst = s.substring(i, j + 1);
                        }
                    }
                }

            }
        }

        return rst;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        LongestPalindromicSubstring_5 myObj = new LongestPalindromicSubstring_5();
        String rst1 = myObj.longestPalindrome(s1);
        System.out.println(rst1);

        String s2 = "bbbb";
        LongestPalindromicSubstring_5 myObj2 = new LongestPalindromicSubstring_5();
        String rst2 = myObj2.longestPalindrome(s2);
        System.out.println(rst2);

    }
}
