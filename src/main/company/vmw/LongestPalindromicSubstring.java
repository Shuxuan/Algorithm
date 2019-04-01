package main.company.vmw;

/**
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
 *
 *
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        for (int len = 1; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i+len)) {
                    if (len == 1 || (len > 1 && dp[i+1][i+len-1])) {
                        dp[i][i+len] = true;
                        if (len + 1 > maxLen) {
                            maxLen = len + 1;
                            start = i;
                        }
                    }
                }

            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        //String input = "babad";
        String input = "cbbd";
        LongestPalindromicSubstring myTest = new LongestPalindromicSubstring();
        System.out.println(myTest.longestPalindrome(input));

    }
}
