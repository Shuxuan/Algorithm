package main.study.algorithm.Array;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum_15 {
    public List<List<Integer>> threeSum_bruteforce(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return rst;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                for (int k = j+1; k < nums.length; k++) {
                    if (k > j+1 && nums[k] == nums[k-1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        rst.add(ans);
                    }
                }
            }
        }

        return rst;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return rst;

        Arrays.sort(nums);

        System.out.println("****************************");
        for (int item : nums)
            System.out.println(item);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;

            int l = i + 1;
            int r = nums.length - 1;


            while (l < r) {
                int target = nums[i] + nums[l] + nums[r];
                if (target < 0) {
                    l++;
                } else if (target > 0) {
                    r--;
                } else {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[l]);
                    ans.add(nums[r]);
                    rst.add(ans);

                    l++;
                    r--;

                    while ( l < r && nums[l] == nums[l-1])
                        l++;
                    while (l < r && nums[r] == nums[r+1])
                        r--;
                }

            }


        }

        return rst;
    }

    public static void main(String[] args) {


        ThreeSum_15 threeSum = new ThreeSum_15();

/*
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> rst = threeSum.threeSum(nums);
        threeSum.printResult(rst);

        int[] nums2 = {0,0,0,0};
        List<List<Integer>> rst2 = threeSum.threeSum(nums2);
        threeSum.printResult(rst2);
*/

        int[] nums3 = {1,-1,-1,0};
        List<List<Integer>> rst3 = threeSum.threeSum(nums3);
        threeSum.printResult(rst3);
/*
        int[] nums4 = {-2,-4,-2};
        List<List<Integer>> rst4 = threeSum.threeSum(nums4);
        threeSum.printResult(rst4);
*/
    }

    private void printResult(List<List<Integer>> rst) {
        for (int i = 0; i < rst.size(); i++) {
            List<Integer> ans = rst.get(i);
            System.out.println("****************");
            for (Integer item : ans) {
                System.out.println(item);
            }
        }
    }
}
