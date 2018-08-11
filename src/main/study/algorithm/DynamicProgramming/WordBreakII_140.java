package main.study.algorithm.DynamicProgramming;

import java.util.*;

/**
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class WordBreakII_140 {
    Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> rst = new ArrayList<>();
        if (map.containsKey(s)) {
            return map.get(s);
        }

        if (s.isEmpty()) {
            rst.add("");
            return rst;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
                for (String sub : sublist) {
                        rst.add(word + (sub.length() == 0 ? "" : " ") + sub);
                }
            }
        }

        map.put(s, rst);
        return rst;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] ss = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = new ArrayList<>();

        for (String word : ss) {
            wordDict.add(word);
        }

        WordBreakII_140 myObj = new WordBreakII_140();
        List<String> rst = myObj.wordBreak(s, wordDict);
        System.out.println(Arrays.toString(rst.toArray()));

    }

}
