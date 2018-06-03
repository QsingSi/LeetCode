import java.util.Queue;

/*
 * [576] Out of Boundary Paths
 *
 * https://leetcode.com/problems/out-of-boundary-paths/description/
 *
 * algorithms
 * Medium (30.60%)
 * Total Accepted:    10.4K
 * Total Submissions: 33.9K
 * Testcase Example:  '2\n2\n2\n0\n0'
 *
 * There is an m by n grid with a ball. Given the start coordinate (i,j) of the
 * ball, you can move the ball to adjacent cell or cross the grid boundary in
 * four directions (up, down, left, right). However, you can at most move N
 * times. Find out the number of paths to move the ball out of grid boundary.
 * The answer may be very large, return it after mod 109 + 7.
 *
 * Example 1:
 *
 * Input:m = 2, n = 2, N = 2, i = 0, j = 0
 * Output: 6
 * Explanation:
 *
 *
 *
 *
 * Example 2:
 *
 * Input:m = 1, n = 3, N = 3, i = 0, j = 1
 * Output: 12
 * Explanation:
 *
 *
 *
 *
 * Note:
 *
 * Once you move the ball out of boundary, you cannot move it back.
 * The length and height of the grid is in range [1,50].
 * N is in range [0,50].
 *
 *
 */
class Solution {
    private int[][] dirs = {
        {
            -1, 0
            }, {
            1, 0
        }, {
            0, 1
        }, {
            0, -1
        }
    };
    private int mod = 1000000000 + 7;
    public int findPaths(int m, int n, int N, int i, int j) {
        long[][][] memo = new long[m][n][N + 1];
        for (int ii = 0; ii < m; ii++) {
            for (int jj = 0; jj < n; jj++) {
                for (int k = 0; k < N + 1; k++)
                    memo[ii][jj][k] = -1;
            }
        }
        return (int)(dfs(m, n, N, i, j, memo) % mod);
    }
    private long dfs(int m, int n, int N, int i, int j, long[][][] memo) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 1;
        if (N == 0)
            return 0;
        if (memo[i][j][N] != -1)
            return memo[i][j][N];
        long cnt = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0], c = j + dir[1];
            cnt = (cnt + dfs(m, n, N - 1, r, c, memo) % mod) % mod;
        }
        memo[i][j][N] = cnt;
        return cnt;
    }
}
