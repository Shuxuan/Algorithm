package main.study.algorithm.Array;

/**
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */
public class WordSearch_79 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,i, j, 0, word))
                    return true;
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

        boolean rst =  dfs(board, i, j-1, len+1, word) ||
                dfs(board,i, j+1, len+1, word) ||
                dfs(board,i-1, j, len+1, word) ||
                dfs(board, i+1, j, len+1, word);

        board[i][j] = word.charAt(len);
        return rst;


    }

    public static void main(String[] args) {

        char[][]  board =
        {
          {'A','B','C','E'},
          {'S','F','C','S'},
          {'A','D','E','E'}
        };

        String word = "ABCCED";
        WordSearch_79 myObj = new WordSearch_79();

        System.out.println(myObj.exist(board,"ABCB"));

    }

}
