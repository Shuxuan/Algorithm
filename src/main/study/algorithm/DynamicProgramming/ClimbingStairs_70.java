package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        int[] df = new int[n+1];
        df[0] = 1;
        df[1] = 1;

        for (int i = 2; i <= n; i++) {
            df[i] = df[i-1] + df[i-2];
        }

        return df[n];
    }

    public static void main(String[] args) {
        int n = 2;
        ClimbingStairs_70 myObj = new ClimbingStairs_70();
        int rst = myObj.climbStairs(n);
        System.out.println(rst);
    }
}
