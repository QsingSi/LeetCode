class Solution {
    public boolean dfs(char[][] board, int i, int j, int now, String word, boolean[][] mask) {
        if (now == word.length()) {
            return true;
        }
        if (i == board.length || i == -1 || j == -1 || j == board[0].length)
            return false;
        if (board[i][j] == word.charAt(now)) {
            if (!mask[i][j]) {
                mask[i][j] = true;
                if (dfs(board, i - 1, j, now + 1, word, mask))
                    return true;
                if (dfs(board, i + 1, j, now + 1, word, mask))
                    return true;
                if (dfs(board, i, j - 1, now + 1, word, mask))
                    return true;
                if (dfs(board, i, j + 1, now + 1, word, mask))
                    return true;
                mask[i][j] = false;
            }
        } else
            return false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m * n < word.length())
            return false;
        boolean[][] mask = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, word, mask))
                        return true;
                }
            }
        }
        return false;
    }
}