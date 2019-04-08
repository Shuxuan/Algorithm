package main.company.ama3.dp;

public class DecodeWays {


    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.length() > 1 && s.charAt(0) == 0)
            return 0;

        int N = s.length();
        int[] dp = new int[N+1];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            if (s.charAt(i-1) == '0')
                dp[i] = 0;
            else dp[i] = dp[i-1];

            if (i > 1 && (s.charAt(i-2) == '1' || s.charAt(i-2) == '2') && s.charAt(i) <= '6') {
                dp[i] += dp[i-2];
            }
        }

        return dp[N];

    }

    public static void main(String[] args) {
        String s = "123";

        DecodeWays myObj = new DecodeWays();
        System.out.println(myObj.numDecodings(s));
    }
}
