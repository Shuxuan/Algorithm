package main.study.algorithm.TwoPointers;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (start < end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        ValidPalindrome myObj = new ValidPalindrome();
        System.out.println(myObj.isPalindrome(s));
    }

}
