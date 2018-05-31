/*
 * [474] Ones and Zeroes
 *
 * https://leetcode.com/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (38.72%)
 * Total Accepted:    21.2K
 * Total Submissions: 54.8K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * In the computer world, use restricted resource you have to generate maximum
 * benefit is what we always want to pursue.
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the
 * other hand, there is an array with strings consisting of only 0s and 1s.
 *
 *
 * Now your task is to find the maximum number of strings that you can form
 * with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 *
 *
 *
 * Note:
 *
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 *
 *
 *
 * Example 1:
 *
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 *
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s
 * and 3 1s, which are “10,”0001”,”1”,”0”
 *
 *
 *
 * Example 2:
 *
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 *
 * Explanation: You could form "10", but then you'd have nothing left. Better
 * form "0" and "1".
 *
 *
 */
class Solution {
    private int dfs(String[] strs, int start, int m, int n, int[][][] memo) {
        if (start == strs.length || (m == 0 && n == 0)) {
            return 0;
        }
        if (memo[m][n][start] > 0)
            return memo[m][n][start];
        int tmpM = 0, tmpN = 0;
        for (int i = 0; i < strs[start].length(); i++)
            tmpM += strs[start].charAt(i) == '0' ? 1 : 0;
        tmpN = strs[start].length() - tmpM;
        int cntInclude = 0;
        if (tmpM <= m && tmpN <= n)
            cntInclude = 1 + dfs(strs, start + 1, m - tmpM, n - tmpN, memo);
        int cntExclude = dfs(strs, start + 1, m, n, memo);
        memo[m][n][start] = Math.max(cntInclude, cntExclude);
        return memo[m][n][start];
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] memo = new int[m + 1][n + 1][strs.length];
        return dfs(strs, 0, m, n, memo);
    }
}
