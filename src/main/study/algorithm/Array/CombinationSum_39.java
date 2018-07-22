package main.study.algorithm.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * <p>
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */

public class CombinationSum_39 {



    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 6, 7};
        int target = 7;
        CombinationSum_39 myclass = new CombinationSum_39();
        List<List<Integer>> rst = myclass.combinationSum(nums, 7);

        for (int i = 0; i < rst.size(); i++) {
            System.out.println("***************************************");
            List<Integer> list = rst.get(i);
            for (int item : list) {
                System.out.println(item);
            }
        }
    }

    //递归
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return rst;
        }

        Arrays.sort(candidates);

        List<Integer> list = new ArrayList<>();
        dfs(candidates, rst, list, target, 0);

        return rst;
    }

    private void dfs(int[] candidates, List<List<Integer>> rst, List<Integer> list, int target, int j) {
        if (target == 0) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i = j; i < candidates.length && target >= candidates[i]; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, rst, list, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

    //非递归
    public List<List<Integer>> combinationSum_norecursion(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return rst;
        }

        Arrays.sort(candidates);



        return rst;
    }
}
