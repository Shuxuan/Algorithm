package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStockIII_123 {

    public int maxProfit(int[] prices) {
        /**
         * 把数组切成俩段，寻找每一个sub array的一次transaction的最大值
         * 然后max = max（max，m1+m2）
         */

        if(prices == null || prices.length < 2) {
            return 0;
        }

        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            int max1 = max(prices, 0, i);
            int max2 = max(prices, i+1, prices.length-1);
            max = Math.max(max, max1 + max2);
        }


        return max;
    }

    private int max(int[] prices, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int max = 0;
        int min = prices[start];
        for (int i = start; i <= end; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            }else
                min = prices[i];
        }

        return max;
    }

    public static void main(String[] args){
        int[] nums = {1,2};
        BestTimetoBuyandSellStockIII_123 myObj = new BestTimetoBuyandSellStockIII_123();
        int rst = myObj.maxProfit(nums);
        System.out.println(rst);
    }

}
