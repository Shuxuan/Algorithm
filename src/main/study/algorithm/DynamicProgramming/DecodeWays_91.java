package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/decode-ways/description/
 *
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
 */
public class DecodeWays_91 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] = nums[i - 1];
            }

            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                nums[i] += nums[i - 2];
            }
        }
        return nums[s.length()];
    }

    public int numDecodings2(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;

        int prev = 0;
        int cur = 1;
        // 长度为n的字符串，有 n+1个阶梯
        for (int i = 1; i <= s.length(); ++i) {
            //判断当前值为0，则当前不能作为答案，
            System.out.println("i : " + i);
            int j = i-1;
            System.out.println("char at " + j + ": " + s.charAt(i-1));
            if (s.charAt(i-1) == '0') cur = 0;

            //判断当年和前一个字符组成数字的情况
            if (i < 2 || !(s.charAt(i - 2) == '1' ||
                    (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')))
                prev = 0;

            System.out.println("prev : " + prev);
            if (i >= 2) {
                System.out.println("char at i-2 : " + s.charAt(i-2));
            }
            int tmp = cur;
            cur = prev + cur;
            prev = tmp;
        }
        return cur;
    }

    public static void main(String[] args) {
        String s = "666";
        DecodeWays_91 myObj = new DecodeWays_91();
        int rst = myObj.numDecodings(s);
        System.out.println(rst);
    }
}
