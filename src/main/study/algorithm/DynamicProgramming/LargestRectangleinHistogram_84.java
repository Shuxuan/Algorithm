package main.study.algorithm.DynamicProgramming;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 *
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 *
 *
 * Example:
 *
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class LargestRectangleinHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
                int index = stack.pop();
                int h = heights[index];
                int w = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
                max = Math.max(max, h * w);
            }

            stack.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
        LargestRectangleinHistogram_84 myObj = new LargestRectangleinHistogram_84();
        int rst = myObj.largestRectangleArea(nums);
        System.out.println(rst);
    }

}
