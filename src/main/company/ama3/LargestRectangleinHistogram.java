package main.company.ama3;

import java.util.Stack;

public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= h) {
                //pop
                int maxh = heights[stack.pop()];
                int w = i - (stack.isEmpty() ? -1 : stack.peek()) - 1;
                result = Math.max(result, maxh * w);

            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        LargestRectangleinHistogram myObj = new LargestRectangleinHistogram();
        System.out.println(myObj.largestRectangleArea(heights));
    }
}
