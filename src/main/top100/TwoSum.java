package main.top100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * 1. Two Sum
 * Easy
 * 9062
 * 271
 *
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        if (nums == null || nums.length == 0) {
            return rst;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                rst[0] = map.get(target - nums[i]);
                rst[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        int[] rst = twoSum.twoSum(nums, target);

        for (int ans : rst) {
            System.out.println(ans);
        }
    }
}
