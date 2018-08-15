package main.study.algorithm.DynamicProgramming;

/**
 *
 * https://leetcode.com/problems/create-maximum-number/description/
 *
 * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 *
 * Note: You should try to optimize your time and space complexity.
 *
 * Example 1:
 *
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * Example 2:
 *
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * Example 3:
 *
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 */
public class CreateMaximumNumber_321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        /**
         * dp[i][j] 代表nums1前i个， nums2前j个 数字组成的最大数字
         */
        dp[0][0] = 0;


        return dp[len1][len2];

    }

}
