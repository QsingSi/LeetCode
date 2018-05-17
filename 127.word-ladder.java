import java.util.Queue;
import java.util.Set;

/*
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (20.20%)
 * Total Accepted:    165.8K
 * Total Submissions: 820.5K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 *
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 *
 *
 * Note:
 *
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 *
 *
 * Example 2:
 *
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 *
 *
 *
 *
 *
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q  = new LinkedList<>();
        q.add(beginWord);
        q.add(null);
        Set<String> visit = new HashSet<>();
        visit.add(beginWord);
        int level = 1;
        while (!q.isEmpty()) {
            String tmp = q.poll();
            if (tmp != null) {
                for (int i = 0; i < tmp.length(); i++) {
                    char[] arr = tmp.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String word = new String(arr);
                        if (word.equals(endWord))
                            return level + 1;
                        if (wordList.contains(word) && !visit.contains(word)) {
                            q.add(word);
                            visit.add(word);
                        }
                    }
                }
            } else {
                level++;
                if (!q.isEmpty())
                    q.add(null);
            }
        }
        return 0;
    }
}
