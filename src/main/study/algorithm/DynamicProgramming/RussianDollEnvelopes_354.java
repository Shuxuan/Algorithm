package main.study.algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/description/
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes_354 {

    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        if (envelopes.length == 1) {
            return 1;
        }

        //按照
        java.util.Arrays.sort(envelopes, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                else
                    return Integer.compare(a[1], b[1]);
            }
        });

        int[] dp = new int[envelopes.length + 1];

        Arrays.fill(dp, 1);
        dp[0] = 0;

        int max = 1;
        for (int i = 2; i <= envelopes.length; i++) {
            for (int j = 1; j < i; j++) {
                if (envelopes[i-1][0] > envelopes[j-1][0] && envelopes[i-1][1] > envelopes[j-1][1]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }


    public static void main(String[] args) {

        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};

        RussianDollEnvelopes_354 myObj = new RussianDollEnvelopes_354();
        int rst = myObj.maxEnvelopes(envelopes);
        System.out.println(rst);
    }

}
