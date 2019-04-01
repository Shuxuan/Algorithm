package main.company.ama3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return rst;
        }

        dfs(candidates, 0, 0, target, new ArrayList<>(), rst);

        return rst;
    }

    private void dfs(int[] candidates, int start, int sum, int target, List<Integer> ans, List<List<Integer>> rst) {
        if (sum == target) {
            List<Integer> item = new ArrayList<>(ans);
            rst.add(item);
            return;
        }

        if (start >= candidates.length || sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            ans.add(candidates[i]);
            dfs(candidates, i, sum + candidates[i], target, ans, rst);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        CombinationSum myObj = new CombinationSum();
        List<List<Integer>> rst = myObj.combinationSum(candidates, target);

        for (List<Integer> ans : rst) {
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }

}
