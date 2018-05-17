class Solution {
    public boolean dfs(char[][] board, int i, int j, String w, int index, boolean[][] mask) {
        // boolean[][] mask = new boolean[board.length][board[0].length];
        if (i == board.length || j == board[0].length || i == -1 || j == -1)
            return false;
        if (index == w.length())
            return true;
        mask[i][j] = true;
        if (i + 1 < board.length && board[i + 1][j] == w.charAt(index) && !mask[i + 1][j]) {
            mask[i + 1][j] = true;
            if (dfs(board, i + 1, j, w, index + 1, mask))
                return true;
            mask[i + 1][j] = false;
        }
        if (i - 1 > -1 && board[i - 1][j] == w.charAt(index) && !mask[i - 1][j]) {
            mask[i - 1][j] = true;
            if (dfs(board, i - 1, j, w, index + 1, mask))
                return true;
            mask[i - 1][j] = false;
        }
        if (j - 1 > -1 && board[i][j - 1] == w.charAt(index) && !mask[i][j - 1]) {
            mask[i][j - 1] = true;
            if (dfs(board, i, j - 1, w, index + 1, mask))
                return true;
            mask[i][j - 1] = false;
        }
        if (j + 1 < board[0].length && board[i][j + 1] == w.charAt(index) && !mask[i][j + 1]) {
            mask[i][j + 1] = true;
            if (dfs(board, i, j + 1, w, index + 1, mask))
                return true;
            mask[i][j + 1] = false;
        }
        mask[i][j] = false;
        return false;

    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> mask = new HashMap<>();
        int m = board.length;
        if (m == 0)
            return res;
        int n = board[0].length;
        for (int k = 0; k < words.length; k++) {
            String tmp = words[k];
            boolean flag = false;
            if (!mask.containsKey(tmp)) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (board[i][j] == tmp.charAt(0) && dfs(board, i, j, tmp, 1, new boolean[m][n])) {
                            flag = true;
                            res.add(tmp);
                            mask.put(tmp, 1);
                            break;
                        }
                    }
                    if (flag)
                        break;
                }
            }
        }
        return res;
    }
}