package main.study.algorithm.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        Arrays.sort(nums);
        List<Integer> item = new ArrayList<>();
        dfs(nums, rst, item, 0);
        return rst;
    }

    private void dfs(int[] nums, List<List<Integer>> rst, List<Integer> item, int pos) {

        rst.add(new ArrayList<>(item));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i-1]) {
                continue;
            }
            item.add(nums[i]);
            dfs(nums, rst, item, i+1);
            item.remove(item.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        SubsetsII_90 myObj = new SubsetsII_90();
        List<List<Integer>> rst = myObj.subsetsWithDup(nums);
        System.out.println(Arrays.toString(rst.toArray()));
    }

}
