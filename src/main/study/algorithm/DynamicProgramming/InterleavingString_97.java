package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/interleaving-string/description/
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class InterleavingString_97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null && s2 == null && s3 == null) {
            return true;
        }

        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        }
        int l1 = s1.length();
        int l2 = s2.length();


        boolean[][] df = new boolean[l1+1][l2+1];
        df[0][0] = true;

        /**
         * df[i][j] 代表s1的前i个字符，s2的前j个字符，是否是s3的前i+j个字符的interleaving
         *
         */



        if (l1 + l2 != s3.length()) {
            return false;
        }

        //first row
        for (int j = 1; j <= l2; j++) {
            df[0][j] = (s2.charAt(j-1) == s3.charAt(j-1)) && df[0][j-1];
        }

        //first column

        for (int i = 1; i <= l1; i++) {
            df[i][0] = (s1.charAt(i-1) == s3.charAt(i-1)) && df[i-1][0];
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                df[i][j] = (df[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (df[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return df[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString_97 myObj = new InterleavingString_97();
        boolean rst = myObj.isInterleave(s1, s2,s3);
        System.out.println(rst);
    }
}
