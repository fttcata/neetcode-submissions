// Will there always be land in the grid? if not just return 0
// Can I move diagonally? no
// can the grid be empty? no
// A naive approach would be to traverse the grid by row and col, using 2 for loops
// And checking if under,left,right,above the current position we have any land
// A more optimal approach would be to find a land cell, and start exploring everywhere using bfs,
// while changing the current one to 0. 
// We can assume that there is water everywhere around the borders, if we reach a border we stop counting.
// Base case of the bfs would be if cell == 0, we return; else we continues doing bfs
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0 ; j < cols; j++)
            {
                // When we find a land, we start bfs
                if (grid[i][j] == '1')
                {
                // Even though the land area would be bigger than just 1, we increment count in the if statement instead of bfs
                count++;
                bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col)
    {
        // Base Cases, either out of bounds or we're on a 0
        if (row >= grid.length || row < 0)
        return;
        if (col >= grid[0].length || col < 0)
        return;
        if (grid[row][col] == '0')
        return;
        grid[row][col] = '0';

        // Call bfs
        bfs(grid, row + 1, col);
        bfs(grid, row - 1, col);
        bfs(grid, row, col - 1);
        bfs(grid, row, col + 1);
    }
    // Time complexity O(n*m);
    // Space Complexity O(n*m);
}
