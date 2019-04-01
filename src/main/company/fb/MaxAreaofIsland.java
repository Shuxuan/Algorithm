package main.company.fb;

import java.util.ArrayList;
import java.util.List;

public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int maxArea = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                List<Integer> rst = new ArrayList<>();
                rst.add(0);
                helper(grid, visited, i, j, rst);
                maxArea = Math.max(maxArea, rst.get(0));
            }
        }

        return maxArea;
    }

    private void helper(int[][] grid, int[][] visited, int i, int j, List<Integer> rst) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        if (visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        rst.add(0, rst.get(0) + 1);
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};
        for (int k = 0; k < 4; k++) {
            int row = i+ dr[k];
            int col = j + dc[k];
            helper(grid, visited, row, col, rst);
        }
    }
}
