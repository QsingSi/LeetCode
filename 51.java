class Solution {
    //注意到每行只能有一个皇后以及皇后之间的位置关系
    public void DFS(int row, int n, int[] pos, List<List<String>> res) {
        if (row == n) {
            List<String> tmp = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == pos[i])
                        s.append("Q");
                    else
                        s.append(".");
                }
                tmp.add(s.toString());
            }
            res.add(tmp);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                pos[row] = i;
                if (isValid(row, pos))
                    DFS(row + 1, n, pos, res);
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

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n == 0)
            return res;
        int[] pos = new int[n];
        DFS(0, n, pos, res);
        return res;
    }
}