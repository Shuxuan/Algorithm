package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray_152 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int max = nums[0];
        int min = max;
        int rst = max;
        for (int i = 1; i < nums.length; i++) {
            int a = max * nums[i];
            int b = min * nums[i];
            max = Math.max(nums[i], Math.max(a,b));
            min = Math.min(nums[i], Math.min(a,b));
            rst = Math.max(rst, max);
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        MaximumProductSubarray_152 myObj = new MaximumProductSubarray_152();
        int rst = myObj.maxProduct(nums);
        System.out.println(rst);
    }

}
