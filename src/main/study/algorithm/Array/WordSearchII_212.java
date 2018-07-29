package main.study.algorithm.Array;


import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example:
 *
 * Input:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * Output: ["eat","oath"]
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII_212 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> rst = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return rst;
        }

        // remove duplicated words, to avoid duplicated items in the result
        Set<String> set = new HashSet<String>();
        for (String word : words) {
            set.add(word);
        }

        for (String word : set) {
            if (findword(board, word)) {
                rst.add((word));
            }
        }
        return rst;

    }

    private boolean findword(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int len, String word) {
        if (len == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(len)) {
            return false;
        }

        board[i][j] = '#';
        boolean rst = dfs(board, i, j-1, len+1, word) ||
                dfs(board, i, j+1, len+1, word) ||
                dfs(board, i-1, j, len+1, word) ||
                dfs(board, i+1, j, len+1, word);
        board[i][j] = word.charAt(len);

        return rst;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}

                };

        String[] words = {"oath","pea","eat","rain"};

        WordSearchII_212 myObj = new WordSearchII_212();
        List<String> rst = myObj.findWords(board, words);
        System.out.println(Arrays.toString(rst.toArray()));


    }
}
