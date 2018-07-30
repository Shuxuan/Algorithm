package main.study.algorithm.Array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return;
        }

        int idx = m + n -1;

        int idx1 = m -1;
        int idx2 = n - 1;

        while (idx1 >= 0 && idx2 >= 0) {

            if (nums1[idx1] > nums2[idx2]) {
                nums1[idx--] = nums1[idx1--];

            } else if (nums1[idx1] < nums2[idx2]) {
                nums1[idx--] = nums2[idx2--];
            } else {
                nums1[idx--] = nums1[idx1--];
                nums1[idx--] = nums2[idx2--];
            }
        }

        while (idx1 >= 0) {
            nums1[idx--] = nums1[idx1--];
        }

        while (idx2 >= 0) {
            nums1[idx--] = nums2[idx2--];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        MergeSortedArray_88 myObj = new MergeSortedArray_88();
        myObj.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
