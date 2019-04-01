package main.company.fb;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int rst = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return rst;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    rst++;
                    dfs(grid, i, j);
                }
            }
        }
        return rst;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);

    }
}
