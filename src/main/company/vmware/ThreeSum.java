package main.company.vmware;

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
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        if (nums == null || nums.length <= 2) {
            return rst;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            if ((i > 0) && (nums[i] == nums[i-1])) {
                continue;
            }
            int leftindex = i+1;
            int rightindex = nums.length - 1;
            int smallest = nums[i] + nums[leftindex] + nums[leftindex+1];
            int largest = nums[i] + nums[rightindex] + nums[rightindex-1];
            if (smallest > 0 || largest < 0)
                continue;
            while (leftindex < rightindex) {
                int sum = nums[i] + nums[leftindex] + nums[rightindex];
                if (sum < 0) {
                    leftindex++;
                } else if (sum > 0) {
                    rightindex--;
                }
                else {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[leftindex]);
                    item.add(nums[rightindex]);
                    rst.add(item);
                    while (leftindex < rightindex && nums[leftindex] == nums[leftindex + 1])
                        leftindex++;
                    while(leftindex < rightindex && nums[rightindex] == nums[rightindex - 1])
                        rightindex--;

                    leftindex++;
                    rightindex--;
                }
            }
        }

        return rst;
    }



    public static void main(String[] args) {
        //int[] nums = {-1, 0, 1, 2, -1, -4};
        //int[] nums = {0,0,0};
        int[] nums = {0,0,0,0};
        //int[] nums = {-2,0,1,1,2};
        ThreeSum myTest = new ThreeSum();
        List<List<Integer>> rst = myTest.threeSum(nums);

        for (List<Integer> item : rst) {
            System.out.println(Arrays.toString(item.toArray()));
        }

        //List<Integer> rst2 = myTest.twoSum(nums, 0, 0);

        //System.out.println(Arrays.toString(rst2.toArray()));


    }
}
