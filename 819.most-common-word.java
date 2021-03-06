import java.util.Iterator;
import java.util.Map;

/*
 * [837] Most Common Word
 *
 * https://leetcode.com/problems/most-common-word/description/
 *
 * algorithms
 * Easy (49.45%)
 * Total Accepted:    7.7K
 * Total Submissions: 15.5K
 * Testcase Example:  '"Bob hit a ball, the hit BALL flew far after it was hit."\n["hit"]'
 *
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words.  It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation.  Words in the paragraph are not case sensitive.  The answer is
 * in lowercase.
 *
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent
 * non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is
 * banned.
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in
 * paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols
 * !?',;.
 * Different words in paragraph are always separated by a space.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation
 * symbols.
 *
 *
 *
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> ban  = Arrays.asList(banned);
        Map<String, Integer> mask = new HashMap<>();
        paragraph = paragraph.toLowerCase();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < paragraph.length();) {
            if (paragraph.charAt(i) == ' ') {
                i++;
                continue;
            }
            int j = i + 1;
            for (; j <= paragraph.length(); j++) {
                if (j == paragraph.length())
                    break;
                if (paragraph.charAt(j) > 'z' || paragraph.charAt(j) < 'a') {
                    words.add(paragraph.substring(i, j));
                    break;
                }
            }
            if (j == paragraph.length() && (paragraph.charAt(j - 1) >= 'a' && paragraph.charAt(j - 1) <= 'z')) {
                words.add(paragraph.substring(i, j));
            }
            i = j + 1;
        }
        for (String w : words) {
            if (ban.contains(w))
                continue;
            mask.put(w, mask.getOrDefault(w, 0) + 1);
        }
        String res = "aaa";
        int max = -1;
        mask.put(res, max);
        Iterator iter = mask.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (val > max) {
                res = key;
                max = val;
            }
        }
        return res;
    }
}
