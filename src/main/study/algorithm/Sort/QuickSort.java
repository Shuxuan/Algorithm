package main.study.algorithm.Sort;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        helper(nums, 0, nums.length-1);
    }
    public void helper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start - 1;
        int pivot = end;
        for (int j = start; j < end; j++) {
            if (nums[j] < nums[pivot]) {
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, pivot);

        helper(nums, start, i-1);
        helper(nums, i+1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {10,80,30,90,40,50,70};
        System.out.println(Arrays.toString(nums));
        QuickSort qs = new QuickSort();

        qs.quickSort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
