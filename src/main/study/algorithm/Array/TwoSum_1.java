package main.study.algorithm.Array;

import java.util.HashMap;
import java.util.Map;

/**
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
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
public class TwoSum_1 {

    /*
    Time complexity: O(n2)
    Space Complexity: O(1)
     */
    public int[] twoSum_BruteForce(int[] nums, int target) {

        if (nums == null && nums.length > 1)
            return null;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    Reduce Time complexity from O(n2) to (O(n)

    Tow-pass Hash Table

    Time  Complexity: O(n)
    Space Complexity: O(n)
     */

    public int[] twoSum_TwoPass(int[] nums, int target) {

        if (nums == null && nums.length > 1)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);

        }

        for (int i = 0; i < nums.length; i++) {
            int candidate = target - nums[i];
            if (map.containsKey(candidate) && map.get(candidate) != i) {
                return new int[] {i, map.get(candidate)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /*
    Reduce Time complexity from O(n2) to (O(n)

    One-pass Hash Table

    Time  Complexity: O(n)
    Space Complexity: O(n)
     */

    public int[] twoSum(int[] nums, int target) {

        if (nums == null && nums.length > 1)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int candiate = target - nums[i];
            if (map.containsKey(candiate) && map.get(candiate) != i) {
                return new int[] {i, map.get(candiate)};
            }

            map.put(nums[i], i);

        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
