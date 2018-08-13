package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII_213 {

    public int rob(int[] nums) {
        /**
         * 不能同时抢第一家和最后一家
         */

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;

        dp[1] = nums[0]; //抢第一家， 不抢最后一家

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }

        int max = dp[n-1];

        dp[1] = 0; //不抢第一家，可以抢最后一家

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }

        max = Math.max(max, dp[n]);

        return max;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        HouseRobberII_213 myObj = new HouseRobberII_213();
        int rst = myObj.rob(nums);
        System.out.println(rst);
    }

}
