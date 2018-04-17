class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0)
            return res;
        int i = 0, j = 0;
        int m = matrix.length, n = matrix[0].length;
        int len = m * n, now = 0;
        int top = 0, left = 0;
        while (now < len) {
            while (j < n && now < len) {
                res.add(matrix[i][j++]);
                now++;
            }
            j--;
            top++;
            while (++i < m && now < len) {
                res.add(matrix[i][j]);
                now++;
            }
            i--;
            n--;
            while (--j >= left && now < len) {
                res.add(matrix[i][j]);
                now++;
            }
            j++;
            m--;
            while (--i >= top && now < len) {
                res.add(matrix[i][j]);
                now++;
            }
            i++;
            left++;
            j++;
        }
        return res;
    }
}