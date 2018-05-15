public class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int neighbors = getNeighbour(board, i, j);
                if (board[i][j] == 1) {
                    if (neighbors == 2 || neighbors == 3)
                        board[i][j] = 3;
                } else {
                    if (neighbors == 3)
                        board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getNeighbour(int[][] board, int row, int col) {
        int cnt = 0;
        for (int i = row - 1; i <= row + 1; ++i) {
            for (int j = col - 1; j <= col + 1; ++j) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    cnt += board[i][j] & 1;
                }
            }
        }
        cnt -= board[row][col] & 1;
        return cnt;
    }
}