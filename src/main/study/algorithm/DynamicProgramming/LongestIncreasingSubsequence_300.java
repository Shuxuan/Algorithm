package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence_300 {


    /**
     * Method of time O(nlogn)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int n = nums.length;
        int[] dp = new int[n];

        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            //更新 nums【i】和len
            if (nums[i] > dp[len-1]) {
                dp[len] = nums[i];
                len++;
            } else if (nums[i] < dp[0]) {
                dp[0] = nums[i];
            } else {
                //在dp【0】和dp【len -1】之间做binary search，寻找更新nums【i】的位置
                int mid = 0;
                int start = 0;
                int end = len - 1;
                while (start + 1 < end) {
                    mid = (end - start) / 2 + start;
                    if (dp[mid] > nums[i]) {
                        end = mid;
                    } else if (dp[mid] < nums[i]) {
                        start = mid;
                    } else {
                        break;
                    }
                }

                if (dp[mid] != nums[i] && nums[i] < dp[end] && nums[i] > dp[start]) {
                    dp[end] = nums[i];
                }
            }
        }

        return len;
    }

    /**
     * Method of time O(n2)
     * @param nums
     * @return
     */
    public int lengthOfLIS_n2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
        //int[] nums = {10,9,2,5,3,4};
        LongestIncreasingSubsequence_300 myObj = new LongestIncreasingSubsequence_300();
        int rst = myObj.lengthOfLIS(nums);
        System.out.println(rst);


    }
}
