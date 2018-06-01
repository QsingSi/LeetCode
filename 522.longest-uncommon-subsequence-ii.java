/*
 * [522] Longest Uncommon Subsequence II
 *
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/
 *
 * algorithms
 * Medium (32.03%)
 * Total Accepted:    11.6K
 * Total Submissions: 36.3K
 * Testcase Example:  '["aba","cdc","eae"]'
 *
 *
 * Given a list of strings, you need to find the longest uncommon subsequence
 * among them. The longest uncommon subsequence is defined as the longest
 * subsequence of one of these strings and this subsequence should not be any
 * subsequence of the other strings.
 *
 *
 *
 * A subsequence is a sequence that can be derived from one sequence by
 * deleting some characters without changing the order of the remaining
 * elements. Trivially, any string is a subsequence of itself and an empty
 * string is a subsequence of any string.
 *
 *
 *
 * The input will be a list of strings, and the output needs to be the length
 * of the longest uncommon subsequence. If the longest uncommon subsequence
 * doesn't exist, return -1.
 *
 *
 * Example 1:
 *
 * Input: "aba", "cdc", "eae"
 * Output: 3
 *
 *
 *
 * Note:
 *
 * All the given strings' lengths will not exceed 10.
 * The length of the given list will be in the range of [2, 50].
 *
 *
 */
class Solution {
    private boolean isSubsequence(String s1, String s2) {
        int i2 = 0;
        for (int i1 = 0; i1 < s1.length() && i2 < s2.length(); i1++) {
            if (s1.charAt(i1) == s2.charAt(i2))
                i2++;
        }
        return i2 == s2.length();
    }
    public int findLUSlength(String[] strs) {
        int len = strs.length;
        int res = -1;
        for (int i = 0; i < len; i++) {
            int j = 0;
            for (; j < len; j++) {
                if (i == j)
                    continue;
                if (isSubsequence(strs[j], strs[i]))
                    break;
            }
            if (j == len)
                res = Math.max(res, strs[i].length());
        }
        return res;
    }
}
