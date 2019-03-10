package main.company.amazon;

public class GameofLife {

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int r = board.length;
        int c = board[0].length;

        int[][] cache = new int[r][c];

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                int liveN = 0;
                for (int k = 0; k < dr.length; k++) {

                    int row = i + dr[k];
                    int col = j + dc[k];
                    if (row < 0 || row >= r || col < 0 || col >= c) {
                        continue;
                    }

                    if (board[row][col] == 1)
                        liveN++;
                }

                if (board[i][j] == 0) {
                    // if 3 live cells around, change to 1

                    if (liveN == 3)
                        cache[i][j] = 1;

                } else {

                    if (liveN < 2) {
                        cache[i][j] = 0;
                    } else if (liveN == 2 || liveN == 3) {
                        cache[i][j] = 1;
                    } else {
                        cache[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] = cache[i][j];
            }
        }

    }

}
