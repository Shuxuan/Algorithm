package main.study.algorithm.Array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }

 */
public class RemoveDuplicatesfromSortedArray_26 {


    public int removeDuplicates(int[] nums) {


        if (nums == null)
            return 0;
        if (nums.length < 2) {
            return nums.length;
        }

        Arrays.sort(nums);

        int idx = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                count++;

            } else {
                count = 1;
            }
            if (count < 2) {
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesfromSortedArray_26 myclass = new RemoveDuplicatesfromSortedArray_26();
        int rst = myclass.removeDuplicates(nums);
        System.out.println(rst);
    }

    public int removeDuplicates1(int[] nums) {


        if (nums == null)
            return 0;
        if (nums.length < 2) {
            return nums.length;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = 1;
        while (right < nums.length) {

            while (right < nums.length && nums[right] == nums[left]) {
                right++;
            }
            if (right < nums.length && left < right) {
                left++;
                nums[left] = nums[right];
                right++;

            }
        }

        return left + 1;
    }


}
