package main.company.ama3.dp;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return nums[0];

        int N = nums.length;
        int[][] dp = new int[N][N];

        for (int len = 1; len <= N; len++) {
            for (int i = 0; i + len -1 < N; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int a = i == 0? 1 : nums[i-1];
                    int c = j == N - 1 ? 1 : nums[j+1];
                    int d = k == 0 ? 0 : dp[i][k-1];
                    int e = k == N - 1 ? 0 : dp[k+1][j];
                    dp[i][j] = Math.max(dp[i][j], a * nums[k] * c + d + e);
                }
            }
        }

        return dp[0][N-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        BurstBalloons myObj = new BurstBalloons();
        System.out.println(myObj.maxCoins(nums));
    }
}
