package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/distinct-subsequences/description/
 *
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example 1:
 *
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 *
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 *
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 *
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 *
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 *   ^  ^^
 * babgbag
 *     ^^^
 */
public class DistinctSubsequences_115 {

    public int numDistinct(String s, String t) {
        if ((s == null || s.isEmpty()) && (t == null || t.isEmpty()))
            return 0;

        if (s.length() < t.length()) {
            return 0;
        }

        int lenS= s.length();
        int lenT = t.length();

        int[][] dp = new int[lenT+1][lenS+1];

        for (int i = 0; i <= lenS;i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= lenT; i++) {
            for (int j = 1; j <= lenS; j++) {
                if (t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else
                    dp[i][j] = dp[i][j-1];
            }
        }

        return dp[lenT][lenS];
    }
}
