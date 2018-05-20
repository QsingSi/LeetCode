/*
 * [318] Maximum Product of Word Lengths
 *
 * https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 *
 * algorithms
 * Medium (45.89%)
 * Total Accepted:    63.4K
 * Total Submissions: 138K
 * Testcase Example:  '["abcw","baz","foo","bar","xtfn","abcdef"]'
 *
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 *
 * Example 1:
 *
 *
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 *
 * Example 2:
 *
 *
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 *
 * Example 3:
 *
 *
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 *
 *
 */
class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            int[] cnt = new int[128];
            boolean flag = true;
            for (char c : words[i].toCharArray())
                cnt[c]++;
            for (int j = i + 1; j < words.length; j++) {
                for (char ch : words[j].toCharArray()) {
                    if (cnt[ch] > 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    max = Math.max(max, words[i].length() * words[j].length());
                flag = true;
            }
        }
        return max;
    }
}
