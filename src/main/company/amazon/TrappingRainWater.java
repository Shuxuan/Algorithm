package main.company.amazon;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 *
 */
public class TrappingRainWater {



    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }

        int rst = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            int curr = (i == height.length) ? 0 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] < curr) {
                int index = stack.pop();
                if (!stack.isEmpty())
                    rst += (Math.min(height[stack.peek()], curr) - height[index]) * ( i - stack.peek() - 1);
            }

            stack.push(i);
        }
        return rst;
    }


    public int trap2(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i>= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int rst = 0;

        for (int i = 0; i < height.length; i++) {
            rst += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return rst;
    }

}
