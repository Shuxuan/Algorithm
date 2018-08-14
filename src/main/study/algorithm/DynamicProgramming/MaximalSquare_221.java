package main.study.algorithm.DynamicProgramming;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-square/description/
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare_221 {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];


        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    }
                    max = Math.max(dp[i][j], max);
                }

            }
        }

        return max * max;
    }

}
