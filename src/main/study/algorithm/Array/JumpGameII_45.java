package main.study.algorithm.Array;

/**
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 */

public class JumpGameII_45 {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
       //greedy, each time, calculate the max range to achieve,

        int rst = 0;

        int i = 0;
        int max = 0;
        int temp = 0;

        while (i < nums.length) {
            if (temp >= nums.length-1) break;
            while (i <= temp) {
                max = Math.max(max, i + nums[i]);
                i++;
            }
            rst++;
            temp = max;
        }
        return rst;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGameII_45 myObj = new JumpGameII_45();
        int rst = myObj.jump(nums);
        System.out.println(rst);
    }
}
