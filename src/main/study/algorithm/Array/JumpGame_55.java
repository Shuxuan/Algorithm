package main.study.algorithm.Array;

/**
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 */
public class JumpGame_55 {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int m = nums.length;
        boolean[] rst = new boolean[m];
        rst[0] = true;

        for (int i = 0; i < m - 1; i++) {
            if (rst[i]) {
                for (int j = i + 1; j <= i + nums[i] && j < m; j++) {
                    rst[j] = true;

                }
            }

        }

        return rst[m-1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame_55 myObject = new JumpGame_55();
        boolean rst = myObject.canJump(nums);
        System.out.println(rst);

        int[] nums1 = {3,2,1,0,4};
        JumpGame_55 myObject1 = new JumpGame_55();
        boolean rst1 = myObject1.canJump(nums1);
        System.out.println(rst1);

    }
}
