class Solution {
    public boolean isValid(char[][] board, int iStart, int jStart, int len) {
        HashMap<Character, Integer> mask = new HashMap<Character, Integer>();
        for (int i = iStart; i < iStart + len; i++) {
            mask.clear();
            for (int j = jStart; j < jStart + len; j++) {
                if (mask.containsKey(board[i][j]) && board[i][j] != '.')
                    return false;
                mask.put(board[i][j], 1);
            }
        }
        for (int i = iStart; i < iStart + len; i++) {
            mask.clear();
            for (int j = jStart; j < jStart + len; j++) {
                if (mask.containsKey(board[j][i]) && board[j][i] != '.')
                    return false;
                mask.put(board[j][i], 1);
            }
        }
        return true;
    }

    public boolean isValidBlock(char[][] board, int iStart, int jStart, int len) {
        HashMap<Character, Integer> mask = new HashMap<Character, Integer>();
        for (int i = iStart; i < iStart + len; i++) {
            for (int j = jStart; j < jStart + len; j++) {
                if (mask.containsKey(board[i][j]) && board[i][j] != '.')
                    return false;
                mask.put(board[i][j], 1);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean rowAndCol = isValid(board, 0, 0, 9);
        boolean block = true;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                block = block & isValidBlock(board, i, j, 3);
            }
        }
        return rowAndCol & block;
    }
}