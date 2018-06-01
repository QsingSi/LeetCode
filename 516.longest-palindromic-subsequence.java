/*
 * [516] Longest Palindromic Subsequence
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * algorithms
 * Medium (42.96%)
 * Total Accepted:    32.4K
 * Total Submissions: 75.3K
 * Testcase Example:  '"bbbab"'
 *
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 *
 *
 * Example 1:
 * Input:
 *
 * "bbbab"
 *
 * Output:
 *
 * 4
 *
 * One possible longest palindromic subsequence is "bbbb".
 *
 *
 * Example 2:
 * Input:
 *
 * "cbbd"
 *
 * Output:
 *
 * 2
 *
 * One possible longest palindromic subsequence is "bb".
 *
 */
class Solution {
    private int dfs(String s, int i, int j, int[][] dp) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (dp[i][j] != 0)
            return dp[i][j];
        int length = 0;
        if (s.charAt(i) == s.charAt(j)) {
            length = Math.max(2 + dfs(s, i + 1, j - 1, dp), length);
        } else
            length = Math.max(dfs(s, i + 1, j, dp), dfs(s, i, j - 1, dp));
        dp[i][j] = length;
        return length;
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return dfs(s, 0, s.length() - 1, dp);
    }
}
