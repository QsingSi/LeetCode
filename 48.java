class Solution {
    public void rotate(int[][] matrix) {
        //先转置，然后沿对称轴交换
        int n = matrix.length;
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        int mid = (n - 1) / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= mid; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}