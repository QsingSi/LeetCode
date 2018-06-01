import java.util.Collections;

/*
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (43.26%)
 * Total Accepted:    23.2K
 * Total Submissions: 53.6K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 *
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 *
 * Example 1:
 *
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 *
 *
 *
 *
 * Example 2:
 *
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * Output:
 * "a"
 *
 *
 *
 * Note:
 *
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 *
 *
 */
class Solution {
    private boolean subSequence(String s1, String s2) {
        int i2 = 0;
        for (int i1 = 0; i1 < s1.length() && i2 < s2.length(); i1++) {
            if (s1.charAt(i1) == s2.charAt(i2))
                i2++;
        }
        return i2 == s2.length();
    }
    public String findLongestWord(String s, List<String> d) {
        StringBuilder sb = new StringBuilder();
        for (String str : d) {
            if (subSequence(s, str)) {
                if (sb.length() < str.length())
                    sb = new StringBuilder(str);
                else if (sb.length() == str.length()) {
                    if (str.compareTo(sb.toString()) < 0)
                        sb = new StringBuilder(str);
                }
            }
        }
        return sb.toString();
    }
}
