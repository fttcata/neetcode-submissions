class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0 ; i < 9; i++)
        {
            Set<Character> row = new HashSet<>();
            for (int j = 0 ; j < 9; j++)
            {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j]))
                        return false;
                    row.add(board[i][j]);
                }
            }
        }

        for (int j = 0 ; j < 9; j++)
        {
            Set<Character> col = new HashSet<>();
            for (int i = 0 ; i < 9; i++)
            {
                if (board[i][j] != '.') {
                    if (col.contains(board[i][j]))
                        return false;
                    col.add(board[i][j]);
                }
            }
        }

        for (int i = 0 ; i < 9; i++)
        {
            Set<Character> grid = new HashSet<>();
            for (int j = 0 ; j < 9; j++)
            {
                int rIndex = (i / 3) * 3 + (j / 3);
                int cIndex = (i % 3) * 3 + (j % 3);
                if (board[rIndex][cIndex] != '.') {
                    if (grid.contains(board[rIndex][cIndex]))
                        return false;
                    grid.add(board[rIndex][cIndex]);
                }
            }
        }
        return true;
    }
}