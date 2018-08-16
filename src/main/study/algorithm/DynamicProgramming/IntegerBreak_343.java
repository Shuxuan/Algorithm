package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/integer-break/description/
 *
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 */
public class IntegerBreak_343 {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        if (n < 4)
            return n-1;

        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(3 * dp[i - 3], 2 * dp[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        IntegerBreak_343 myObj = new IntegerBreak_343();
        int rst = myObj.integerBreak(n);

        System.out.println(rst);
    }

}
