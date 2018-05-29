import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

/*
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (52.03%)
 * Total Accepted:    54.6K
 * Total Submissions: 105K
 * Testcase Example:  '"tree"'
 *
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 *
 *
 *
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 *
 *
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 *
 */
class Solution {
    public String frequencySort(String s) {
        char[] arr = s.toCharArray();
        int[] cnt = new int[128];
        for (char ch : arr)
            cnt[ch]++;
        SortedMap<Integer, Set<Character>> mask = new TreeMap<>();
        for (char ch : arr) {
            mask.computeIfAbsent(cnt[ch], k->new HashSet<>()).add(ch);
        }
        List<Set<Character>> vals = new ArrayList<>(mask.values());
        StringBuilder res = new StringBuilder();
        for (int i = vals.size() - 1; i >= 0; i--) {
            List<Character> tmp = new ArrayList(vals.get(i));
            for (Character ch : tmp) {
                for (int j = 0; j < cnt[ch]; j++)
                    res.append(ch);
            }
        }
        return res.toString();
    }
}
