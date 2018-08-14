package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockwithCooldown_309 {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        /**
         * 引入辅助数组sells和buys
         *
         * sells[i]表示在第i天卖出股票所能获得的最大累积收益
         * buys[i]表示在第i天买入股票所能获得的最大累积收益
         *
         * 初始化令sells[0] = 0，buys[0] = -prices[0]
         *
         * 第i天交易时获得的累计收益只与第i-1天与第i-2天有关
         *
         * 记第i天与第i-1天的价格差：delta = price[i] - price[i - 1]
         *
         * 状态转移方程为：
         *
         * sells[i] = max(buys[i - 1] + prices[i], sells[i - 1] + delta)
         * buys[i] = max(sells[i - 2] - prices[i], buys[i - 1] - delta)
         * 上述方程的含义为：
         *
         * 第i天卖出的最大累积收益 = max(第i-1天买入~第i天卖出的最大累积收益, 第i-1天卖出后反悔~改为第i天卖出的最大累积收益)
         * 第i天买入的最大累积收益 = max(第i-2天卖出~第i天买入的最大累积收益, 第i-1天买入后反悔~改为第i天买入的最大累积收益)
         * 而实际上：
         *
         * 第i-1天卖出后反悔，改为第i天卖出 等价于 第i-1天持有股票，第i天再卖出
         * 第i-1天买入后反悔，改为第i天买入 等价于 第i-1天没有股票，第i天再买入
         * 所求的最大收益为max(sells)。显然，卖出股票时才可能获得收益。
         */
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = 0 - prices[0];
        buy[1] = 0 - prices[1];
        sell[1] = Math.max(prices[1] - prices[0], 0);
        int max = sell[1];

        for (int i = 2; i < n; i++) {
            int delta = prices[i] - prices[i-1];
            buy[i] = Math.max(sell[i-2] - prices[i], buy[i-1] - delta);
            sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1] + delta);
            max = Math.max(sell[i], max);
        }

        return max;

    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy = 0;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        BestTimetoBuyandSellStockwithCooldown_309 myObj = new BestTimetoBuyandSellStockwithCooldown_309();
        int rst = myObj.maxProfit(nums);

        System.out.println(rst);
    }

}
