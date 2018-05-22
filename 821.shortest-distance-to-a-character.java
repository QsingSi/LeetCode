/*
 * [841] Shortest Distance to a Character
 *
 * https://leetcode.com/problems/shortest-distance-to-a-character/description/
 *
 * algorithms
 * Easy (63.10%)
 * Total Accepted:    8K
 * Total Submissions: 12.7K
 * Testcase Example:  '"loveleetcode"\n"e"'
 *
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 *
 * Example 1:
 *
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 *
 *
 *
 * Note:
 *
 *
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 *
 *
 */
class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] arr = S.toCharArray();
        List<Integer> index = new ArrayList<>();
        int[] dis = new int[S.length()];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == C)
                index.add(i);
        for (int i = 0; i < S.length(); i++) {
            for (Integer pos : index)
                dis[i] = Math.min(Math.abs(pos - i), dis[i]);
        }
        return dis;
    }
}
