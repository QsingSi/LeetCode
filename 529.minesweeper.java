/*
 * [529] Minesweeper
 *
 * https://leetcode.com/problems/minesweeper/description/
 *
 * algorithms
 * Medium (49.46%)
 * Total Accepted:    18K
 * Total Submissions: 36.4K
 * Testcase Example:  '[["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]]\n[3,0]'
 *
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents
 * an unrevealed mine, 'E' represents an unrevealed empty square, 'B'
 * represents a revealed blank square that has no adjacent (above, below, left,
 * right, and all 4 diagonals) mines, digit ('1' to '8') represents how many
 * mines are adjacent to this revealed square, and finally 'X' represents a
 * revealed mine.
 *
 * Now given the next click position (row and column indices) among all the
 * unrevealed squares ('M' or 'E'), return the board after revealing this
 * position according to the following rules:
 *
 *
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it
 * to revealed blank ('B') and all of its adjacent unrevealed squares should be
 * revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then
 * change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 *
 *
 * Example 1:
 *
 * Input:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 * ⁠['E', 'E', 'M', 'E', 'E'],
 * ⁠['E', 'E', 'E', 'E', 'E'],
 * ⁠['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'M', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 *
 *
 *
 * Example 2:
 *
 * Input:
 *
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'M', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 * ⁠['B', '1', 'X', '1', 'B'],
 * ⁠['B', '1', '1', '1', 'B'],
 * ⁠['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 *
 *
 *
 *
 *
 * Note:
 *
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which
 * also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been
 * revealed).
 * For simplicity, not mentioned rules should be ignored in this problem. For
 * example, you don't need to reveal all the unrevealed mines when the game is
 * over, consider any cases that you will win the game or flag any squares.
 *
 *
 */
class Solution {
    private void dfs(char[][] board, int r, int c, boolean[][] visit) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return;
        if (board[r][c] == 'M') {
            return;
        }
        if (board[r][c] == '1')
            return;
        int cnt = 0;
        visit[r][c] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i == 0 && j == 0) || (r + i < 0 || c + j < 0 || r + i >= board.length || c + j >= board[0].length)) {
                    continue;
                } else {
                    cnt += board[r + i][c + j] == 'M' ? 1 : 0;
                }
            }
        }
        if (cnt > 0)
            board[r][c] = Character.forDigit(cnt, 10);
        else
            board[r][c] = 'B';
        if (board[r][c] >= 'A') {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i == 0 && j == 0) || (r + i < 0 || c + j < 0 || r + i >= board.length || c + j >= board[0].length)) {
                        continue;
                    } else {
                        if (!visit[r + i][c + j]) {
                            visit[r + i][c + j] = true;
                            dfs(board, r + i, c + j, visit);
                        }
                    }
                }
            }
        }
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            dfs(board, r, c, new boolean[board.length][board[0].length]);
        }
        return board;
    }
}
