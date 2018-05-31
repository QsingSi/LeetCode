/*
 * [498] Diagonal Traverse
 *
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (45.72%)
 * Total Accepted:    19.9K
 * Total Submissions: 43.6K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 *
 *
 * Example:
 *
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 *
 *
 *
 *
 * Note:
 *
 * The total number of elements of the given matrix will not exceed 10,000.
 *
 *
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        for (int k = 0; k < res.length; k++) {
            res[k] = matrix[i][j];
            if (((i + j) & 1) == 0) {
                if (j == n - 1)
                    i++;
                else if (i == 0)
                    j++;
                else {
                    i--;
                    j++;
                }
            } else {
                if (i == m - 1)
                    j++;
                else if (j == 0)
                    i++;
                else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
