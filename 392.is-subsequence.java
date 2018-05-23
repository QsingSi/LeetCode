/*
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence/description/
 *
 * algorithms
 * Medium (44.71%)
 * Total Accepted:    53.4K
 * Total Submissions: 119.5K
 * Testcase Example:  '"abc"\n"ahbgdc"'
 *
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 *
 *
 * You may assume that there is only lower case English letters in both s and
 * t. t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (
 *
 *
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 *
 *
 * Example 1:
 * s = "abc", t = "ahbgdc"
 *
 *
 * Return true.
 *
 *
 * Example 2:
 * s = "axc", t = "ahbgdc"
 *
 *
 * Return false.
 *
 *
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you
 * want to check one by one to see if T has its subsequence. In this scenario,
 * how would you change your code?
 *
 * Credits:Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= t.length(); i++)
            dp[0][i] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
