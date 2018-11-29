package main.study.algorithm.Array;


/**
 *
 * https://leetcode.com/problems/rotate-image/description/
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Note:
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Given input matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * Example 2:
 *
 * Given input matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * rotate the input matrix in-place such that it becomes:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 */
public class RotateImage_48 {

    public void rotate(int[][] matrix) {

    }

    /**
     * https://leetcode.com/problems/contains-duplicate-iii/description/
     *
     * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3, t = 0
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,0,1,1], k = 1, t = 2
     * Output: true
     * Example 3:
     *
     * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
     * Output: false
     */
    public static class ContainsDuplicateIII_220 {

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (nums == null || nums.length == 0)
                return false;

            return true;
        }

    }
}
