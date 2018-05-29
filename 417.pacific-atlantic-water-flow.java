/*
 * [417] Pacific Atlantic Water Flow
 *
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (34.94%)
 * Total Accepted:    26.7K
 * Total Submissions: 76.5K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * Given an m x n matrix of non-negative integers representing the height of
 * each unit cell in a continent, the "Pacific ocean" touches the left and top
 * edges of the matrix and the "Atlantic ocean" touches the right and bottom
 * edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a
 * cell to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 *
 * Note:
 *
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *
 *
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 * ⁠ Pacific ~   ~   ~   ~   ~
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with
 * parentheses in above matrix).
 *
 *
 */
class Solution {
    List<int[]> res = new ArrayList<>();
    private void dfs(int[][] mat, int i, int j, char[][] visited, char now) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return;
        if (now == 'A' && visited[i][j] == 'P')
            res.add(new int[] {i, j});
        if (visited[i][j] == now)
            return;
        visited[i][j] = now;
        if (i + 1 < mat.length && mat[i][j] <= mat[i + 1][j])
            dfs(mat, i + 1, j, visited, now);
        if (j + 1 < mat[0].length && mat[i][j] <= mat[i][j + 1])
            dfs(mat, i, j + 1, visited, now);
        if (i - 1 >= 0 && mat[i][j] <= mat[i - 1][j])
            dfs(mat, i - 1, j, visited, now);
        if (j - 1 >= 0 && mat[i][j] <= mat[i][j - 1])
            dfs(mat, i, j - 1, visited, now);
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return res;
        char[][] visited = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++)
            dfs(matrix, 0, i, visited, 'P');
        for (int i = 0; i < matrix.length; i++)
            dfs(matrix, i, 0, visited, 'P');
        for (int i = 0; i < matrix[0].length; i++)
            dfs(matrix, matrix.length - 1, i, visited, 'A');
        for (int i = 0; i < matrix.length; i++)
            dfs(matrix, i, matrix[0].length - 1, visited, 'A');
        return res;
    }
}
