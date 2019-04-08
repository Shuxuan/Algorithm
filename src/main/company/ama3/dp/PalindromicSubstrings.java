package main.company.ama3.dp;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int N = s.length();
        boolean[][] dp = new boolean[N+1][N+1];

        int count = -1;
        for (int i = 0; i <= N; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i + len <= N - 1; i++ ) {
                int j = i + len - 1;
                System.out.println(i);
                System.out.println(j);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = len == 2 ? true : dp[i+1][j-1];
                }
                if (dp[i][j])
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        PalindromicSubstrings myObj = new PalindromicSubstrings();
        int count = myObj.countSubstrings(s);
        System.out.println(count);
    }
}
