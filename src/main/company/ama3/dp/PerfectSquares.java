package main.company.ama3.dp;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (j * j <= i) {
                min = Math.min(min, 1 + dp[i - j*j]);
                j++;
            }

            dp[i] = min;
        }

        return dp[n];
     }

}
