package main.company.ama3.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int N = s.length();
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        for (int len = 1; len < N; len++) {
            for (int i = 0; i + len < N; i++) {
                if (s.charAt(i) == s.charAt(i+len)) {
                    if (len == 1 || dp[i+1][i+len-1]) {
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
