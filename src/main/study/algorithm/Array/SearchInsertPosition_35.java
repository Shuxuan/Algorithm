package main.study.algorithm.Array;

/**
 * https://leetcode.com/problems/search-insert-position/description/
 * <p>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition_35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        SearchInsertPosition_35 myclass = new SearchInsertPosition_35();
        int rst = myclass.searchInsert(nums, target);
        System.out.println(rst);
    }

    public int searchInsert(int[] nums, int target) {
        int rst = 0;
        if (nums == null || nums.length == 0 || target < nums[0]) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                if (m < nums.length - 1 && target < nums[m + 1]) {
                    return m + 1;
                }

                l = m + 1;

            } else if (nums[m] > target) {
                if (m > 0 && target > nums[m - 1]) {
                    return m;
                }

                r = m - 1;

            } else {
                return m;
            }
        }

        return rst;

    }
}
