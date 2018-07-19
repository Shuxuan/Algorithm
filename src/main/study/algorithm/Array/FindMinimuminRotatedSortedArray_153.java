package main.study.algorithm.Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class FindMinimuminRotatedSortedArray_153 {

    public int findMin(int[] nums) {
        int rst = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0) {
            return rst;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r)/2;
            if (nums[m] <= nums[r]) {

                if ( m == 0 || ( m > 0 && nums[m] < nums[m-1])) {
                    // m 是最小值位置
                    return nums[m];
                }
                r = m - 1;
                rst = Math.min(rst, nums[m]);
            } else {
                l = m + 1;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        FindMinimuminRotatedSortedArray_153 myclass = new FindMinimuminRotatedSortedArray_153();
        int rst = myclass.findMin(nums);
        System.out.println(rst);


    }
}
