package main.study.algorithm.Array;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum_64 {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[] rst = new int[n];

        rst[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            rst[i] = rst[i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            rst[0] = rst[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                rst[j] = Math.min(rst[j-1],rst[j] ) + grid[i][j];
            }
        }

        return rst[n-1];

    }
}
