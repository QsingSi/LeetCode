/*
 * [891] Score After Flipping Matrix
 *
 * https://leetcode.com/problems/score-after-flipping-matrix/description/
 *
 * algorithms
 * Medium (68.41%)
 * Total Accepted:    3.2K
 * Total Submissions: 4.6K
 * Testcase Example:  '[[0,0,1,1],[1,0,1,0],[1,1,0,0]]'
 *
 * We have a two dimensional matrix A where each value is 0 or 1.
 *
 * A move consists of choosing any row or column, and toggling each value in
 * that row or column: changing all 0s to 1s, and all 1s to 0s.
 *
 * After making any number of moves, every row of this matrix is interpreted as
 * a binary number, and the score of the matrix is the sum of these numbers.
 *
 * Return the highest possible score.
 *
 *
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * Output: 39
 * Explanation:
 * Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 *
 * Note:
 *
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] is 0 or 1.
 *
 *
 */
class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < n; j++)
                    A[i][j] ^= 1;
            }
        }
        for (int j = 1; j < n; j++) {
            int cnt = 0;
            for (int i = 0; i < m; i++)
                if (A[i][j] == 1)
                    cnt++;
            if (m > 2 * cnt) {
                for (int i = 0; i < m; i++)
                    A[i][j] ^= 1;
            }
        }
        int sum = 0;
        for (int[] arr : A) {
            int tmp = 0;
            for (int num : arr)
                tmp = tmp * 2 + num;
            sum += tmp;
        }
        return sum;
    }
}
