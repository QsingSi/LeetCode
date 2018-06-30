/*
 * [839] Short Encoding of Words
 *
 * https://leetcode.com/problems/short-encoding-of-words/description/
 *
 * algorithms
 * Medium (40.71%)
 * Total Accepted:    3.3K
 * Total Submissions: 8.1K
 * Testcase Example:  '["time", "me", "bell"]'
 *
 * Given a list of words, we may encode it by writing a reference string S and
 * a list of indexes A.
 *
 * For example, if the list of words is ["time", "me", "bell"], we can write it
 * as S = "time#bell#" and indexes = [0, 2, 5].
 *
 * Then for each index, we will recover the word by reading from the reference
 * string from that index until we reach a "#" character.
 *
 * What is the length of the shortest reference string S possible that encodes
 * the given words?
 *
 * Example:
 *
 *
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 *
 *
 * Note:
 *
 *
 * 1 <= words.length <= 2000.
 * 1 <= words[i].length <= 7.
 * Each word has only lowercase letters.
 *
 *
 */
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b)-> {
            StringBuilder a1 = new StringBuilder(a);
            StringBuilder b1 = new StringBuilder(b);
            return a1.reverse().toString().compareTo(b1.reverse().toString());
        });
        int res = words[0].length() + 1;
        for (int i = 1; i < words.length; i++) {
            if (words[i].contains(words[i - 1]))
                res += words[i].length() - words[i - 1].length();
            else
                res += words[i].length() + 1;
        }
        return res;
    }
}