import java.util.Set;

/*
 * [720] Longest Word in Dictionary
 *
 * https://leetcode.com/problems/longest-word-in-dictionary/description/
 *
 * algorithms
 * Easy (41.64%)
 * Total Accepted:    17.5K
 * Total Submissions: 41.9K
 * Testcase Example:  '["w","wo","wor","worl","world"]'
 *
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words.  If there is more than one possible answer, return the
 * longest word with the smallest lexicographical order.  If there is no
 * answer, return the empty string.
 *
 * Example 1:
 *
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor",
 * and "worl".
 *
 *
 *
 * Example 2:
 *
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary.
 * However, "apple" is lexicographically smaller than "apply".
 *
 *
 *
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 *
 */
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b)->a.length() - b.length());
        Set<String> set = new HashSet<>();
        String res = "z";
        for (String word : words)
            set.add(word);
        for (int i = words.length - 1; i >= 0; i--) {
            int len = words[i].length();
            boolean mark = true;
            while (len-- > 1) {
                if (!set.contains(words[i].substring(0, len))) {
                    mark = false;
                    break;
                }
            }
            if (mark) {
                if (words[i].length() > res.length() || (words[i].length() == res.length() && words[i].compareTo(res) < 0))
                    res = words[i];
            }
        }
        return res;
    }
}
