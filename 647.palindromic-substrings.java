/*
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (54.52%)
 * Total Accepted:    43.6K
 * Total Submissions: 80K
 * Testcase Example:  '"abc"'
 *
 *
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 *
 *
 *
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 *
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 *
 * Note:
 *
 * The input string length won't exceed 1000.
 *
 *
 */
class Solution {
    private int cnt = 0;
    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
    }
    public int countSubstrings(String s) {
        if (s.length() <= 1)
            return s.length();
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return cnt;
    }
}
