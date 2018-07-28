package main.study.algorithm.Array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return rst;

        List<Integer> item = new ArrayList<>();
        dfs(nums, rst, item, 0);

        return rst;
    }

    public void dfs(int[] nums, List<List<Integer>> rst, List<Integer> item, int pos) {
        rst.add(new ArrayList<>(item));
        for (int i = pos; i < nums.length; i++) {
            item.add(nums[i]) ;
            dfs(nums, rst, item, i+1);
            item.remove(item.size()-1);
        }
    }

}
