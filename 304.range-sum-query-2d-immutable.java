/*
 * [304] Range Sum Query 2D - Immutable
 *
 * https://leetcode.com/problems/range-sum-query-2d-immutable/description/
 *
 * algorithms
 * Medium (27.50%)
 * Total Accepted:    44.7K
 * Total Submissions: 162.6K
 * Testcase Example:  '["NumMatrix","sumRegion","sumRegion","sumRegion"]\n[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]'
 *
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle
 * defined by its upper left corner (row1, col1) and lower right corner (row2,
 * col2).
 *
 *
 *
 * The above rectangle (with the red border) is defined by (row1, col1) = (2,
 * 1) and (row2, col2) = (4, 3), which contains sum = 8.
 *
 *
 * Example:
 *
 * Given matrix = [
 * ⁠ [3, 0, 1, 4, 2],
 * ⁠ [5, 6, 3, 2, 1],
 * ⁠ [1, 2, 0, 1, 5],
 * ⁠ [4, 1, 0, 1, 7],
 * ⁠ [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 *
 *
 *
 * Note:
 *
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 *
 */
class NumMatrix {
    public int[][] nums;
    public int[][] sum;
    public NumMatrix(int[][] matrix) {
        nums = Arrays.copyOf(matrix, matrix.length);
        if (matrix.length == 0)
            return;
        sum = new int[nums.length][nums[0].length];
        sum[0][0] = nums[0][0];
        for (int i = 1; i < nums.length; i++)
            sum[i][0] = sum[i - 1][0] + nums[i][0];
        for (int i = 1; i < nums[0].length; i++)
            sum[0][i] = sum[0][i - 1] + nums[0][i];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + nums[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 || col1 == 0) {
            if (row1 == 0 && col1 == 0)
                return sum[row2][col2];
            if (row1 == 0)
                return sum[row2][col2] - sum[row2][col1 - 1];
            if (col1 == 0)
                return sum[row2][col2] - sum[row1 - 1][col2];
        }
        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
