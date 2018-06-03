/*
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (36.26%)
 * Total Accepted:    22.4K
 * Total Submissions: 61.9K
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's
 * permutations is the substring of the second string.
 *
 * Example 1:
 *
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 *
 *
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 *
 *
 */
class Solution {
    private boolean judge(int[] cnt, String b) {
        int[] cnt1 = new int[26];
        for (char ch : b.toCharArray())
            cnt1[ch - 'a']++;
        return Arrays.equals(cnt, cnt1);
    }
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int[] cnt = new int[26];
        for (char ch : s1.toCharArray())
            cnt[ch - 'a']++;
        for (int i = 0; i + len <= s2.length(); i++)
            if (judge(cnt, s2.substring(i, i + len)))
                return true;
        return false;
    }
}
