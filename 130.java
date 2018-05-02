class Solution {
    public void dfs(char[][] c, int row, int col) {
        if (c[row][col] != 'O')
            return;
        c[row][col] = 'A';
        if (row > 0)
            dfs(c, row - 1, col);
        if (row < c.length - 1)
            dfs(c, row + 1, col);
        if (col > 0)
            dfs(c, row, col - 1);
        if (col < c[row].length - 1)
            dfs(c, row, col + 1);
    }

    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'A' ? 'O' : 'X';
            }
        }
    }
}