package main.study.algorithm.Array;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        int rst = Integer.MAX_VALUE;

        if (nums == null || nums.length < 3)
            return rst;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                     if (rst == Integer.MAX_VALUE || Math.abs(sum - target) < Math.abs(rst - target)) {
                        rst = sum;
                    }
                    left++;
                } else if (sum > target) {
                    if (rst == Integer.MAX_VALUE || Math.abs(sum - target) < Math.abs(rst - target)) {
                        rst = sum;
                    }
                    right--;
                } else {
                    return target;
                }
            }
        }


        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -5, 3,-4};
        int target = -1;

        ThreeSumClosest_16 threeSumClosest_16 = new ThreeSumClosest_16();
        int rst = threeSumClosest_16.threeSumClosest(nums, target);
    }
}
