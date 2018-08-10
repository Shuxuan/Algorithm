package main.study.algorithm.DynamicProgramming;

/**
 *
 * https://leetcode.com/problems/palindrome-partitioning-ii/description/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII_132 {
    boolean[][] isPalindrome;
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        isPalindrome(s);
        int[] dp = new int[s.length()+1];
        for(int i = 0; i <= s.length(); i++) {
            dp[i] = i-1;
        }

        for (int i = 2; i <= s.length(); i++) {
            for (int j = i; j >= 1; j--) {
                if (isPalindrome[j-1][i-1])
                    dp[i] = Math.min(dp[i], dp[j-1] +1);
            }
        }

        return dp[s.length()];
    }

    private void isPalindrome(String s) {
        isPalindrome = new boolean[s.length()][s.length()];

        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i+l < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i+l)) {
                    isPalindrome[i][i+l] = (l==0 || l==1) ? true : isPalindrome[i+1][i+l-1];
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";

        PalindromePartitioningII_132 myObj = new PalindromePartitioningII_132();
        int rst = myObj.minCut(s);

        System.out.println(rst);
    }
}
