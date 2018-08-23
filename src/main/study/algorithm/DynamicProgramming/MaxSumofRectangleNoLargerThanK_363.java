package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 *
 * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
 *
 * Example:
 *
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
 * Output: 2
 * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
 *              and 2 is the max number no larger than k (k = 2).
 * Note:
 *
 * The rectangle inside the matrix must have an area > 0.
 * What if the number of rows is much larger than the number of columns?
 */
public class MaxSumofRectangleNoLargerThanK_363 {

    /*
     * If # of columns is smaller, process one set of columns [i..j) at a time, for each different i<j.
     * For one set of colums [i..j), do it like "Count of Range Sum".
     * O(n) = n^2 * mlogm.
     * Assume we have such result.
     */

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, ans = Integer.MIN_VALUE;
        long[] sum = new long[m+1]; // stores sum of rect[0..p][i..j]
        for (int i = 0; i < n; ++i) {
            long[] sumInRow = new long[m];
            for (int j = i; j < n; ++j) { // for each rect[*][i..j]
                for (int p = 0; p < m; ++p) {
                    sumInRow[p] += matrix[p][j];
                    sum[p+1] = sum[p] + sumInRow[p];
                }
                ans = Math.max(ans, mergeSort(sum, 0, m+1, k));
                if (ans == k) return k;
            }
        }
        return ans;
    }
    int mergeSort(long[] sum, int start, int end, int k) {
        if (end == start+1) return Integer.MIN_VALUE; // need at least 2 to proceed
        int mid = start + (end - start)/2, cnt = 0;
        int ans = mergeSort(sum, start, mid, k);
        if (ans == k) return k;
        ans = Math.max(ans, mergeSort(sum, mid, end, k));
        if (ans == k) return k;
        long[] cache = new long[end-start];
        for (int i = start, j = mid, p = mid; i < mid; ++i) {
            while (j < end && sum[j] - sum[i] <= k) ++j;
            if (j-1 >= mid) {
                ans = Math.max(ans, (int)(sum[j-1] - sum[i]));
                if (ans == k) return k;
            }
            while (p < end && sum[p] < sum[i]) cache[cnt++] = sum[p++];
            cache[cnt++] = sum[i];
        }
        System.arraycopy(cache, 0, sum, start, cnt);
        return ans;
    }
}
