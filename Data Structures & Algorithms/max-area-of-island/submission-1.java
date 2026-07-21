class Solution {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0)
        return 0;

        // Variables for rows and columns
        int n = grid.length;
        int m = grid[0].length;

        // Traverse the grid.
        for (int i = 0 ; i < n; i++)
        {
            for (int j = 0 ; j < m; j++)
            {
                // If we encounter a 1
                if (grid[i][j] == 1)
                count = Math.max(dfs(grid,i,j), count);
            }
        }
        return count;
    }

    private int dfs(int[][] grid, int row, int col)
    {
        // Base cases
        if (row > grid.length -1 || row < 0)
        return 0;
        if (col > grid[0].length - 1 || col < 0)
        return 0;

        if (grid[row][col] == 0)
        return 0;

        grid[row][col] = 0;
        return 1 +
        dfs(grid, row-1, col) +
        dfs(grid, row+1, col) +
        dfs(grid, row, col-1) +
        dfs(grid, row, col+1);
    }
}
