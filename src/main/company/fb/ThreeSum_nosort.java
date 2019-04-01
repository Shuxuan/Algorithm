package main.company.fb;

import java.util.*;

public class ThreeSum_nosort {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        if (nums == null || nums.length <= 2) {
            return rst;
        }

        Map<Integer, Integer> count = new HashMap<>();// key, count

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i : count.keySet()) {
            for (int j : count.keySet()) {

                // i <= k <= j
                int k = 0 - i - j;


                if (!(i <= k && k <= j)) {
                    continue;
                }

                if (i == k && count.get(k) < 2) continue;
                if (k == j && count.get(k) < 2) continue;
                if (i == j && count.get(k) < 3) continue;

                if (count.containsKey(k)) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    item.add(k);
                    rst.add(item);
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {1,1,-2};
        ThreeSum_nosort myObj = new ThreeSum_nosort();
        List<List<Integer>> rst = myObj.threeSum(nums);
        for (List<Integer> item : rst) {
            System.out.println(Arrays.toString(item.toArray()));
        }

    }
}
