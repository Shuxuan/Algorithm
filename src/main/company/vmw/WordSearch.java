package main.company.vmw;

public class WordSearch {

    int[] dr = {0, 0, -1, 1};
    int[] dc = {1, -1, 0, 0};

     public boolean exist(char[][] board, String word) {
        if (word == null || board == null || (board.length == 0 && board[0].length == 0)) {
            return true;
        }
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (helper(board, i, j, word, 0, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean helper(char[][] board, int r, int c, String word, int index, boolean[][] visited) {
         if (index == word.length()) {
             return true;
         }

         if (r >= board.length || r < 0 || c >= board[0].length || c < 0) {
             return false;
         }

        if (visited[r][c])
            return false;

        if (board[r][c] != word.charAt(index)) {
             return false;
         }
         visited[r][c] = true;
         for (int i = 0; i < 4; i++) {
             int row = r + dr[i];
             int col = c + dc[i];
             if (helper(board, row, col, word, index+ 1, visited))
                 return true;
         }

         visited[r][c] = false;

         return false;
    }

    public static void main(String[] args) {

         /*char[][] board = {
                 {'A','B','C','E'},
                 {'S','F','C','S'},
                 {'A','D','E','E'}
         };

         String word = "SEE";*/


        char[][] board = {
                {'A','A'}
        };

        String word = "AAA";


        WordSearch myObj = new WordSearch();
        System.out.println(myObj.exist(board, word));
    }

}
