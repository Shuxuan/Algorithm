package main.study.algorithm.Array;

/**
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

public class FindFirstandLastPositionofElementinSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {

        int[] rst = {-1, -1};
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {

            return rst;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if ( nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                //相等，往左，往右探测是否还有相等的
                l = m;
                r = m;
                while (l > 0 && nums[l] == nums[l-1]) {
                    l--;
                }

                while (r < nums.length - 1 && nums[r] == nums[r+1]) {
                    r++;
                }

                rst[0] = l;
                rst[1] = r;
                return rst;
            }
        }

        return rst;

    }

}
