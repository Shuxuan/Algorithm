package main.study.algorithm.DynamicProgramming;

/**
 *
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

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        int m = grid.length;
        int n = grid[0].length;

        int[] df = new int[n];

        df[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            df[i] = df[i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    df[j] = df[j] + grid[i][j];
                } else {
                    df[j] = Math.min(df[j-1], df[j]) + grid[i][j];
                }
            }
        }

        return df[n-1];

    }

    public static void main(String[] args){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumPathSum_64 myObj = new MinimumPathSum_64();
        int rst = myObj.minPathSum(grid);
        System.out.println(rst);

    }
}
