package main.company.facebook;

import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CoinChange {


    private int minCnt = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0)
            return -1;
        Arrays.sort(coins);
        coinChange(coins, amount, coins.length - 1, 0);
        return minCnt == Integer.MAX_VALUE ? -1 : minCnt;
    }

    private void coinChange(int[] coins, int amount, int index, int cnt) {
        if (index < 0)
            return;
        for (int i = amount / coins[index]; i >= 0; i--) {
            int curAmount = amount - coins[index] * i;
            int curCnt = cnt + i;
            if (curAmount > 0 && curCnt + 1 < minCnt) {
                coinChange(coins, curAmount, index - 1, curCnt);
            } else {
                if (curAmount == 0 && curCnt < minCnt) {
                    minCnt = curCnt;
                }
                break;
            }
        }
    }

    public int coinChange_dp(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            if(Arrays.binarySearch(coins, i) >= 0) {
                dp[i] = 1;
            } else {
                for (int j = 1; j < i; j++) {
                    if (dp[j] != Integer.MAX_VALUE && dp[i-j] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);

                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        CoinChange myObj = new CoinChange();

        System.out.println(Arrays.binarySearch(coins, 1) >= 0);
        int rst = myObj.coinChange(coins, 11);
        System.out.println(rst);


    }
}
