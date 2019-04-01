package main.company.vmw;


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
  */
public class DecodeWays {
    int rst = 0;
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;

        helper(s, 0);

        return rst;
    }

    private void helper(String s, int index) {
        if (index == s.length()) {
            rst++;
            return;
        }
        if (index > s.length()) {
            return;
        }

        if (index + 1 <= s.length()) {
            String one = s.substring(index, index + 1);

            if (Integer.valueOf(one) > 0) {
                helper(s, index + 1);
            }
        }

        if (index + 2 <= s.length()) {
            String two = s.substring(index, index + 2);
            if (Integer.valueOf(two) >= 10 && Integer.valueOf(two) <= 26) {
                helper(s, index + 2);
            }
        }

    }
}
