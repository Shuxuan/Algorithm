package main.company.ama3.dp;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int maxans = 0;

        //dp[i] 代表以i的位置为ending的substring的longgest valid parenthesis
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s1 = "(()";
        String s2 = ")()())";

        LongestValidParentheses myObj = new LongestValidParentheses();
        //System.out.println(myObj.longestValidParentheses(s1));
        System.out.println(myObj.longestValidParentheses(s2));
    }
}
