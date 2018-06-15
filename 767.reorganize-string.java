import java.util.Map;
import java.util.PriorityQueue;

/*
 * [778] Reorganize String
 *
 * https://leetcode.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (36.08%)
 * Total Accepted:    6.7K
 * Total Submissions: 18.5K
 * Testcase Example:  '"aab"'
 *
 * Given a string S, check if the letters can be rearranged so that two
 * characters that are adjacent to each other are not the same.
 *
 * If possible, output any possible result.  If not possible, return the empty
 * string.
 *
 * Example 1:
 *
 *
 * Input: S = "aab"
 * Output: "aba"
 *
 *
 * Example 2:
 *
 *
 * Input: S = "aaab"
 * Output: ""
 *
 *
 * Note:
 *
 *
 * S will consist of lowercase letters and have length in range [1, 500].
 *
 *
 *
 */
class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> mask = new HashMap<>();
        for (char ch : S.toCharArray()) {
            int cnt = mask.getOrDefault(ch, 0) + 1;
            if (cnt > (S.length() + 1) / 2)
                return "";
            mask.put(ch, cnt);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char ch : mask.keySet()) {
            pq.add(new int[] {
                       ch, mask.get(ch)
                   });
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            if (sb.length() == 0 || top[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char)top[0]);
                if (--top[1] > 0)
                    pq.add(top);
            } else {
                int[] sec = pq.remove();
                sb.append((char) sec[0]);
                if (--sec[1] > 0)
                    pq.add(sec);
                pq.add(top);
            }
        }
        return sb.toString();
    }
}
