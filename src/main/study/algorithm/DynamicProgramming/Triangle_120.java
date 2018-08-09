package main.study.algorithm.DynamicProgramming;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle/description/
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }

        List<Integer> lastRow = triangle.get(triangle.size()-1);
        int[] df = new int[lastRow.size()];

        for (int i = 0; i < lastRow.size(); i++) {
            df[i] = lastRow.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i++) {
            List<Integer> currentRow = triangle.get(i);
            for(int j = 0; j <currentRow.size(); j++) {
                df[j] = currentRow.get(j) + Math.min(df[j], df[j+1]);
            }
        }

        return df[0];

    }
}
