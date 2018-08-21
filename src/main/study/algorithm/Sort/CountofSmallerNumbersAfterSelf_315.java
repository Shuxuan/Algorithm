package main.study.algorithm.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */
public class CountofSmallerNumbersAfterSelf_315 {
    public List<Integer> countSmaller(int[] nums) {

        List<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rst;
        }

        int n = nums.length;
        int[] status = new int[n];

        status[0] = nums[n-1];
        rst.add(0, 0);

        for (int i = n-2; i >= 0; i--) {
            int index = merge(status, n-2 - i, nums[i]);
            rst.add(0, index);
        }


        return rst;
    }

    public int merge(int[] status, int end, int target) {
        int left = 0;
        int right = end;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (target <= status[mid]) {
                right = mid;
            }else
                left = mid;
        }

        if (target > status[right]) {
            status[right+1] = target;
            return right + 1;
        }


        if (target <= status[left]) {
            for (int i = end+1; i >left; i--) {

                status[i] = status[i-1];
            }

            status[left] = target;
            return left;

        }


        for (int i = end+1; i > right; i--) {
            status[i] = status[i-1];
        }
        status[right] = target;
        return right;


    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};


        CountofSmallerNumbersAfterSelf_315 myObj = new CountofSmallerNumbersAfterSelf_315();
        List<Integer> rst = myObj.countSmaller(nums);
        System.out.println(Arrays.toString(rst.toArray()));


    }
}
