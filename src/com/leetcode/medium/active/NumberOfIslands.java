package com.leetcode.medium.active;

/**
 * Number of Islands
 * Link: https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    private static final char ISLAND = '1';

    /**
     * Solution:
     * - Time: O(nm)
     * - Space: O(nm)
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int count = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == ISLAND) {
                    findIsland(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void findIsland(char[][] grid, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        if (i + 1 < grid.length && grid[i + 1][j] == ISLAND) {
            findIsland(grid, i + 1, j, visited);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == ISLAND) {
            findIsland(grid, i - 1, j, visited);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == ISLAND) {
            findIsland(grid, i, j + 1, visited);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == ISLAND) {
            findIsland(grid, i, j - 1, visited);
        }
    }
}
