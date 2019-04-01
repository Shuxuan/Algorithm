package main.company.sorting;

import java.util.Arrays;

public class QuickSort {

    public void quickSort(int[] nums) {
        helper(nums, 0, nums.length -1);
    }

    private void helper(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];
        while (left < right) {
            while (left < right && nums[left] < pivot) {
                left++;
            }

            while (left < right && pivot < nums[right]) {
                right--;
            }

            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }

        nums[start] = nums[left];
        nums[left] = pivot;

        helper(nums, start, left-1);
        helper(nums, left+1, end);
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, 0 , 8 , -4, 6};
        QuickSort myObj = new QuickSort();
        myObj.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
