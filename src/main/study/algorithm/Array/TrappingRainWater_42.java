package main.study.algorithm.Array;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater_42 {

    public int trap(int[] height) {
        int rst = 0;

        if (height == null || height.length == 0) {
            return rst;
        }

        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];

        int l = height[0];
        int r = height[height.length-1];

        for (int i = 0; i < height.length; i++) {
            l = Math.max(l, height[i]);
            maxL[i] = l;
        }

        for (int i = height.length - 1; i >= 0; i--) {
            r = Math.max(r, height[i]);
            maxR[i] = r;
        }

        for (int i = 0; i < height.length; i++) {
            int min = Math.min(maxL[i], maxR[i]);
            rst += min - height[i];
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater_42 mytest = new TrappingRainWater_42();
        int rst = mytest.trap(nums);
        System.out.println(rst);
    }
}
