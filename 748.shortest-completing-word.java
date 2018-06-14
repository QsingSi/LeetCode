/*
 * [749] Shortest Completing Word
 *
 * https://leetcode.com/problems/shortest-completing-word/description/
 *
 * algorithms
 * Medium (51.95%)
 * Total Accepted:    8.2K
 * Total Submissions: 15.7K
 * Testcase Example:  '"1s3 PSt"\n["step","steps","stripe","stepple"]'
 *
 *
 * Find the minimum length word from a given dictionary words, which has all
 * the letters from the string licensePlate.  Such a word is said to complete
 * the given string licensePlate
 *
 * Here, for letters we ignore case.  For example, "P" on the licensePlate
 * still matches "p" on the word.
 *
 * It is guaranteed an answer exists.  If there are multiple answers, return
 * the one that occurs first in the array.
 *
 * The license plate might have the same letter occurring multiple times.  For
 * example, given a licensePlate of "PP", the word "pair" does not complete the
 * licensePlate, but the word "supper" does.
 *
 *
 * Example 1:
 *
 * Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe",
 * "stepple"]
 * Output: "steps"
 * Explanation: The smallest length word that contains the letters "S", "P",
 * "S", and "T".
 * Note that the answer is not "step", because the letter "s" must occur in the
 * word twice.
 * Also note that we ignored case for the purposes of comparing whether a
 * letter exists in the word.
 *
 *
 *
 * Example 2:
 *
 * Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * Output: "pest"
 * Explanation: There are 3 smallest length words that contains the letters
 * "s".
 * We return the one that occurred first.
 *
 *
 *
 * Note:
 *
 * licensePlate will be a string with length in range [1, 7].
 * licensePlate will contain digits, spaces, or letters (uppercase or
 * lowercase).
 * words will have a length in the range [10, 1000].
 * Every words[i] will consist of lowercase letters, and have length in range
 * [1, 15].
 *
 *
 */
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = new int[128];
        char[] arr = licensePlate.toLowerCase().toCharArray();
        for (char ch : arr) {
            if (ch >= 'a' && ch <= 'z')
                cnt[ch]++;
        }
        int minLen = Integer.MAX_VALUE, index = 1001;
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() <= minLen && helper(words[i], cnt)) {
                minLen = words[i].length();
                index = i;
            }
        }
        return words[index];
    }
    private boolean helper(String s, int[] cnt) {
        int[] tmp = new int[128];
        for (char ch : s.toCharArray()) {
            tmp[ch]++;
        }
        for (int i = 0; i < cnt.length; i++)
            if (tmp[i] < cnt[i])
                return false;
        return true;
    }
}
