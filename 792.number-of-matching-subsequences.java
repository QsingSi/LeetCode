/*
 * [808] Number of Matching Subsequences
 *
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 * algorithms
 * Medium (36.45%)
 * Total Accepted:    7.4K
 * Total Submissions: 20.3K
 * Testcase Example:  '"abcde"\n["a","bb","acd","ace"]'
 *
 * Given string S and a dictionary of words words, find the number of words[i]
 * that is a subsequence of S.
 *
 *
 * Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S:
 * "a", "acd", "ace".
 *
 *
 * Note:
 *
 *
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 *
 */
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int cnt = 0;
        for (String word : words)
            if (helper(S, word))
                cnt++;
        return cnt;
    }
    private boolean helper(String s1, String s2) {
        int i = 0, j = 0, l1 = s1.length(), l2 = s2.length();
        if (l2 > l1)
            return false;
        while (i < l1 && j < l2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else i++;
        }
        return j == l2;
    }
}
