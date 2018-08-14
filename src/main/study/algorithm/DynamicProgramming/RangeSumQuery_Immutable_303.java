package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/description/
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQuery_Immutable_303 {

}

class NumArray {
    int[] sum = null;
    int[] nums = null;
    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums == null || nums.length == 0) {
            return;
        }
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (i <= j) {
            if (i == 0) {
                return sum[j];
            } else {
                return sum[j] - sum[i-1];
            }
        }

        return 0;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

