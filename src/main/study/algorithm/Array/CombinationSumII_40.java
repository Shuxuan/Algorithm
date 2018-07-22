package main.study.algorithm.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */

public class CombinationSumII_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();

        Arrays.sort(candidates);

        if (candidates == null || candidates.length == 0) {
            return rst;
        }

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
            if (i > j && candidates[i] == candidates[i-1])
                continue;
            list.add(candidates[i]);
            dfs(candidates, rst, list, target - candidates[i], i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSumII_40 mytest = new CombinationSumII_40();
        List<List<Integer>> rst = mytest.combinationSum2(candidates, target);

        for (int i = 0; i < rst.size(); i++) {
            List<Integer> list = rst.get(i);
            System.out.println("********************");
            for (int item : list) {
                System.out.println(item);
            }
        }
    }
}
