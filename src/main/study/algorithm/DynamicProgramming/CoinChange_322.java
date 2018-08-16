package main.study.algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange_322 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        Arrays.sort(coins);

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0 && dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            dp[amount] = -1;
        }

        return dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        CoinChange_322 myObj = new CoinChange_322();
        int rst = myObj.coinChange(coins, amount);

        System.out.println(rst);
    }

}
