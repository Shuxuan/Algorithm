package main.study.algorithm.Array;

/**
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 *
 */
public class FindMinimuminRotatedSortedArrayII_154 {

    public int findMin(int[] nums) {

        int rst = nums[0];

        if ( nums == null || nums.length == 0) {
            return rst;
        }

        int l = 0;
        int r = nums.length - 1;

        while ( l <= r) {
            int m = (l + r)/2;

            if ( nums[m] < nums[r]) {

                rst = Math.min(rst, nums[m]);
                r = m - 1;

            } else if (nums[m] > nums[r]) {
                rst = Math.min(rst, nums[r]);
                l = m + 1;

            } else {
                r--;

            }
        }

        if (l >= 0 && l < nums.length)
            rst = Math.min(rst, nums[l]);
        if (r >= 0 && r < nums.length)
            rst = Math.min(rst, nums[r]);

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        FindMinimuminRotatedSortedArrayII_154 myclass = new FindMinimuminRotatedSortedArrayII_154();
        int rst = myclass.findMin(nums);
        System.out.println(rst);
    }
}
