package main.study.algorithm.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> rst = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return rst;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;

                int left = j+1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        rst.add(ans);
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return rst;

    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        FourSum_18 fourSum_18 = new FourSum_18();
        List<List<Integer>> rst = fourSum_18.fourSum(nums, target);
        fourSum_18.printResult(rst);

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
