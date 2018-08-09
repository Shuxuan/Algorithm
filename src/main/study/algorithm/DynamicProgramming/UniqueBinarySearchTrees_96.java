package main.study.algorithm.DynamicProgramming;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTrees_96 {

    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTrees_96 myObj = new UniqueBinarySearchTrees_96();
        int rst = myObj.numTrees(n);
        System.out.println(rst);
    }

}
