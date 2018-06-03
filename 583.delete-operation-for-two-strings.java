/*
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * algorithms
 * Medium (44.71%)
 * Total Accepted:    18.1K
 * Total Submissions: 40.4K
 * Testcase Example:  '"sea"\n"eat"'
 *
 *
 * Given two words word1 and word2, find the minimum number of steps required
 * to make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 *
 *
 * Example 1:
 *
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to
 * make "eat" to "ea".
 *
 *
 *
 * Note:
 *
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 *
 *
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0 || len2 == 0)
            return Math.max(len1, len2);
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char ch : word1.toCharArray())
            cnt1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            cnt2[ch - 'a']++;
        int cnt = 0;
        for (char ch : word1.toCharArray()) {
            if (cnt2[ch - 'a'] == 0)
                cnt += cnt1[ch - 'a'];
            else if (cnt2[ch - 'a'] > cnt1[ch - 'a']) {
                cnt += cnt2[ch - 'a'] - cnt1[ch - 'a'];
                cnt2[ch - 'a'] = cnt1[ch - 'a'];
            } else if (cnt2[ch - 'a'] < cnt1[ch - 'a']) {
                cnt += cnt1[ch - 'a'] - cnt2[ch - 'a'];
                cnt1[ch - 'a'] = cnt2[ch - 'a'];
            }
        }
        for (char ch : word2.toCharArray()) {
            if (cnt1[ch - 'a'] == 0)
                cnt += cnt2[ch - 'a'];
            else if (cnt2[ch - 'a'] > cnt1[ch - 'a']) {
                cnt += cnt2[ch - 'a'] - cnt1[ch - 'a'];
                cnt2[ch - 'a'] = cnt1[ch - 'a'];
            } else if (cnt2[ch - 'a'] < cnt1[ch - 'a']) {
                cnt += cnt1[ch - 'a'] - cnt2[ch - 'a'];
                cnt1[ch - 'a'] = cnt2[ch - 'a'];
            }
        }
        return cnt;
    }
}
