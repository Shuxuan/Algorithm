package main.study.algorithm.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning_131 {

    boolean[][] status;

    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return rst;
        }

        status = new boolean[s.length()][s.length()];
        updatePalindromeStatus(s);
        dfs(s, 0, rst, new ArrayList<>());

        return rst;

    }

    private void dfs(String s, int pos, List<List<String>> rst, ArrayList<String> path) {
        if (pos == s.length()) {
            rst.add(new ArrayList<>(path));
            return;
        }
        if (pos > s.length()) {
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (status[pos][i]){
                path.add(s.substring(pos, i+1));
                dfs(s, i+1, rst, path);
                path.remove(path.size()-1);
            }
        }
    }

    private void updatePalindromeStatus(String s) {
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i + l < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i+l))
                    status[i][i+l] = (l==1 || l==0) ? true : status[i][i+l-1];
            }
        }
    }


}
