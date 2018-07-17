package main.study.algorithm.Array;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 * |        |
 * |_|____|_|
 */
public class ContainerWithMostWater_11 {

    /*
    brute force, calculate every possible two lines, shorter line * width
     */
    public int maxArea_bruthforce(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i+1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return max;
    }

    /*
        instead of bruth force, use tow pointer s
     */

    public int maxArea(int[] height) {
        int rst = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            rst = Math.max(rst, Math.min(height[l], height[r]) * (r-l));
            if (height[l] < height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return rst;
    }
}
