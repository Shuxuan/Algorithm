package main.study.algorithm.Array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/description/
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors_75 {

    public void sortColors(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int redStart = 0;
        int blueStart = nums.length - 1;
        int i = 0;

        while (i <= blueStart) {
            if (nums[i] == 0) {
                swap(nums, i, redStart);
                redStart++;
                i++;

                //A[cur] = 0：交换A[cur]和A[left]。由于A[left]=1或left=cur，所以交换以后A[cur]已经就位，cur++，left++
            } else if (nums[i] == 2) {
                swap(nums, i, blueStart);
                blueStart--;
            } else
                i++;

        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColors_75 myObj = new SortColors_75();
        myObj.sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
