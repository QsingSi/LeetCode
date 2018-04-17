class Solution {
    public int res;

    public void DFS(int row, int n, int[] pos) {
        if (row == n) {
            res++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                pos[row] = i;
                if (isValid(row, pos))
                    DFS(row + 1, n, pos);
            }
        }
    }

    public boolean isValid(int row, int[] pos) {
        for (int i = 0; i < row; i++) {
            if (pos[i] == pos[row] || Math.abs(pos[row] - pos[i]) == row - i)
                return false;
        }
        return true;
    }

    public int totalNQueens(int n) {
        if (n <= 0)
            return 0;
        int[] pos = new int[n];
        DFS(0, n, pos);
        return res;
    }
}