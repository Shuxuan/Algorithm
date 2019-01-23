package main.VMWare;

/**
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 */
public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
           if (nums[mid] < nums[right]) {

                // mid to right,  sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else
                    right = mid - 1;

            } else {
               // left to mid , sorted

               if (target >= nums[left] && target < nums[mid]) {
                   right = mid - 1;
               } else
                   left = mid + 1;

            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        SearchinRotatedSortedArray myTest = new SearchinRotatedSortedArray();
        System.out.println(myTest.search(nums, 3));
    }
}
