/*
 * [413] Arithmetic Slices
 *
 * https://leetcode.com/problems/arithmetic-slices/description/
 *
 * algorithms
 * Medium (54.53%)
 * Total Accepted:    39.6K
 * Total Submissions: 72.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * A sequence of number is called arithmetic if it consists of at least three
 * elements and if the difference between any two consecutive elements is the
 * same.
 *
 * For example, these are arithmetic sequence:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 *
 * The following sequence is not arithmetic. 1, 1, 2, 5, 7
 *
 *
 * A zero-indexed array A consisting of N numbers is given. A slice of that
 * array is any pair of integers (P, Q) such that 0
 *
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * ⁠   A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this
 * means that P + 1 < Q.
 *
 * The function should return the number of arithmetic slices in the array
 * A.
 *
 *
 * Example:
 *
 * A = [1, 2, 3, 4]
 *
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3,
 * 4] itself.
 *
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        boolean[][] dp = new boolean[A.length][A.length];
        for (int i = 0; i + 3 <= A.length; i++) {
            dp[i][i + 2] = A[i] - A[i + 1] == A[i + 1] - A[i + 2];
            sum += (dp[i][i + 2] == true) ? 1 : 0;
        }
        for (int l = 4; l <= A.length; l++) {
            for (int i = 0; i + l <= A.length; i++) {
                dp[i][i + l - 1] = dp[i][i + l - 2] && A[i] - A[i + 1] == A[i + l - 2] - A[i + l - 1];
                sum += (dp[i][i + l - 1] == true) ? 1 : 0;
            }
        }
        return sum;
    }
}
