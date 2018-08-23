package main.study.algorithm.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-of-range-sum/description/
 *
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 *
 * Example:
 *
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
public class CountofRangeSum_327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int ans = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        ans = sort(sum, 0, nums.length + 1, lower, upper);
        return ans;
    }

    public int sort(long[] sum, int l, int r, int lower, int upper) {
        if (r - l <= 1)	return 0;
        int ret = 0;
        int mid = (l + r) >> 1;
        long[] temp = new long[r - l];
        ret += sort(sum, l, mid, lower, upper) + sort(sum, mid, r, lower, upper);
        int rl = mid, rr = mid, j = mid;
        for (int i = l, k = 0; i < mid; ++i) {
            if (rl < r && sum[rl] - sum[i] <= upper) {
                while (rl < r && sum[rl] - sum[i] < lower) rl++;
                while (rr < r && sum[rr] - sum[i] <= upper)	rr++;
                ret += rr - rl;
            }
            while (j < r && sum[j] < sum[i]) temp[k++] = sum[j++];
            temp[k++] = sum[i];
        }
        System.arraycopy(temp, 0, sum, l, j - l);
        return ret;
    }

    public int countRangeSum_bruteforce(int[] nums, int lower, int upper) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        // 注意这里是long而不是int，防止俩个都是max or min的时候溢出
        long[] sum = new long[n+1];

        int rst = 0;

        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (sum[j] - sum[i] >= lower && sum[j] - sum[i] <= upper) {
                    rst++;
                }
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};

        CountofRangeSum_327 myObj = new CountofRangeSum_327();

        System.out.println(myObj.countRangeSum(nums, -2,2));

        int[] nums2 = {-2147483647,0,-2147483647,2147483647};
        int lower = -564;
        int upper = 3864;

        System.out.println(myObj.countRangeSum(nums2, lower, upper));

    }
}
