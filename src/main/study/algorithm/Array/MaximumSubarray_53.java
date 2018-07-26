package main.study.algorithm.Array;


/**
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray_53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int rst = nums[0];
        int[] f = new int[nums.length];
        f[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i-1] + nums[i], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            rst = Math.max(rst, f[i]);
        }

        return rst;

    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray_53 myObj = new MaximumSubarray_53();
        int rst = myObj.maxSubArray(nums);
        System.out.println(rst);
    }
}
