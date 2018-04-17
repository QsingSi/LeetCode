class Solution {
    //递归解决，类似有N皇后问题
    public boolean solveSoduDFS(char[][] board, int i, int j) {
        if (i == 9)
            return true;
        if (j >= 9)
            return solveSoduDFS(board, i + 1, 0);
        if (board[i][j] == '.') {
            for (char k = '1'; k <= '9'; ++k) {
                board[i][j] = k;
                if (isValid(board, i, j)) {
                    if (solveSoduDFS(board, i, j + 1))
                        return true;
                }
                board[i][j] = '.';
            }
        } else {
            return solveSoduDFS(board, i, j + 1);
        }
        return false;
    }

    public boolean isValid(char[][] board, int i, int j) {
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][j] == board[i][col])
                return false;
        }
        for (int row = 0; row < 9; row++) {
            if (row != i && board[i][j] == board[row][j])
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; ++row) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; ++col) {
                if ((row != i || col != j) && (board[row][col] == board[i][j]))
                    return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9)
            return;
        solveSoduDFS(board, 0, 0);
    }
}