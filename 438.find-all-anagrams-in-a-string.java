/*
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Easy (33.95%)
 * Total Accepted:    63.7K
 * Total Submissions: 187.7K
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 *
 *
 *
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;
        if (s.length() == p.length()) {
            if (s.equals(p))
                res.add(0);
            return res;
        }
        for (int i = 0; i + p.length() <= s.length(); i++) {
            if (judge(s.substring(i, i + p.length()), p))
                res.add(i);
        }
        return res;
    }
    public boolean judge(String a, String b) {
        int[] cnt = new int[128];
        for (char c : a.toCharArray())
            cnt[c]++;
        for (char c : b.toCharArray())
            cnt[c]--;
        for (int n : cnt)
            if (n != 0)
                return false;
        return true;
    }
}
