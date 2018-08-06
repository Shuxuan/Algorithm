package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/edit-distance/description/
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance_72 {

    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null || word1.isEmpty() && word2.isEmpty()) {
            return 0;
        }

        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] df = new int[len1+1][len2+1];


        for (int i = 0; i < len2 + 1; i++) {
            df[0][i] = i;
        }

        for (int j = 0; j < len1 + 1; j++) {
            df[j][0] = j;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    df[i][j] = df[i-1][j-1];
                } else {
                    df[i][j] = Math.min(df[i-1][j-1], df[i-1][j]);
                    df[i][j] = Math.min(df[i][j], df[i][j-1]);
                    df[i][j]++;
                }
            }
        }

        return df[len1][len2];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        EditDistance_72 myObj = new EditDistance_72();
        int rst = myObj.minDistance(word1, word2);

        System.out.println(rst);
    }
}
