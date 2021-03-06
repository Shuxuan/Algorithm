package main.study.algorithm.TwoPointers;

import java.util.Arrays;

/** https://leetcode.com/problems/move-zeroes/description/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = 0;

        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) {
                i++;
            }

            if ( i == nums.length - 1) return;
            int j = i + 1;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }

            if (j < nums.length) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }

            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes myObj = new MoveZeroes();
        myObj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
