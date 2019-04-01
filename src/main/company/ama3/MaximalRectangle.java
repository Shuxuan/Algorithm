package main.company.ama3;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int result = 0;

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return result;

        int row = matrix.length;
        int col = matrix[0].length;

        int[] heighs = new int[col];

        for (int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                heighs[j] = (matrix[i][j] == '0') ? 0 : heighs[j] + 1;
            }
            int tmpMax = largestRectangleArea(heighs);
            result = Math.max(tmpMax, result);
        }

        return result;
    }

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

}
