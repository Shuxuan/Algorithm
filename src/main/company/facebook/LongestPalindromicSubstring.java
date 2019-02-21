package main.company.facebook;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }

        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;
        for (int len = 1; len < length; len ++) {
            for (int i = 0; i + len < length; i++) {
                if (s.charAt(i) == s.charAt(i+len)) {
                    if (len == 1 || (len > 1 && dp[i+1][i+len -1])) {
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
}
