package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/burst-balloons/description/
 * <p>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * <p>
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons_312 {

    public int maxCoins(int[] nums) {
        /**
         * 用DP的方法做，设一个二维数组来保存从第i个气球到第j个气球burst之后的结果。
         * 假设是dp[i][j]， 最终的答案就是dp[0][n - 1]（n个气球），
         * 然后因为头和尾在burst的时候，旁边相当于是1，所以把input的数组，头尾补上1.
         * 然后求dp[i][j]的过程就是，从i到j扫一遍，k = i to j，
         * 我们把第k位当成是最后burst的点，这时候，k位左边的，和k位右边的都已经消失了，所以num[k] * num[i - 1] * num[j + 1]是最后这次burst的值。
         * 之前burst的值你就可以通过dp[i, k - 1] + dp[k + 1, j] 来得到（这就是递推式子）。知道了怎么递推的，后面应该就好写了。
         *
         */
        int n = nums.length;
        if(n==0)
            return 0;
        int dp[][] = new int[n][n];
        for(int len = 1 ; len <=n; len++){
            for(int left = 0; left<= n - len; left++ ){
                int right = len + left -1;
                for(int k=left; k<=right; k++){
                    int leftNum = 1;
                    int rightNum = 1;
                    int beforeDp = 0;
                    int afterDp = 0;

                    if(left != 0)
                        leftNum = nums[left-1];
                    if(right != n-1)
                        rightNum = nums[right+1];
                    if(k != left)
                        beforeDp = dp[left][k-1];
                    if(k != right)
                        afterDp = dp[k+1][right];

                    dp[left][right] = Math.max(dp[left][right], leftNum*nums[k]*rightNum + beforeDp + afterDp);
                }
            }
        }
        return dp[0][n-1];
    }


    public int maxCoins2(int[] iNums) {
        /**
         * 用DP的方法做，设一个二维数组来保存从第i个气球到第j个气球burst之后的结果。
         * 假设是dp[i][j]， 最终的答案就是dp[0][n - 1]（n个气球），
         * 然后因为头和尾在burst的时候，旁边相当于是1，所以把input的数组，头尾补上1.
         * 然后求dp[i][j]的过程就是，从i到j扫一遍，k = i to j， 我们把第k位当成是最后burst的点，这时候，k位左边的，和k位右边的都已经消失了，所以num[k] * num[i - 1] * num[j + 1]是最后这次burst的值。之前burst的值你就可以通过dp[i, k - 1] + dp[k + 1, j] 来得到（这就是递推式子）。知道了怎么递推的，后面应该就好写了。
         *
         */
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }


}
