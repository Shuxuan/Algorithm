package main.study.algorithm.Array;

/**
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 */
public class SearchinRotatedSortedArrayII_81 {

    public boolean search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return false;

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r)/2;
            if (target == nums[m]) {
                return true;
            }

            if (nums[m] < nums[r]) {
                // 上升序列
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            } else if (nums[m] > nums[r]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m -1;
                } else {
                    l = m + 1;
                }

            } else {
                r--;

            }
        }

        return false;
    }
}
