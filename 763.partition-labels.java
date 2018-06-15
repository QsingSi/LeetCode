/*
 * [768] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (64.66%)
 * Total Accepted:    15.3K
 * Total Submissions: 23.6K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 *
 * A string S of lowercase letters is given.  We want to partition this string
 * into as many parts as possible so that each letter appears in at most one
 * part, and return a list of integers representing the size of these parts.
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits S into less parts.
 *
 *
 *
 * Note:
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 *
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        int left = 0;
        List<Integer> res = new ArrayList<>();
        int[] rightMost = new int[128];
        Arrays.fill(rightMost, -1);
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            rightMost[arr[i]] = i;
        }
        while (left < arr.length) {
            char ch = arr[left];
            int right = rightMost[ch];
            for (int i = left; i < right; i++)
                right = Math.max(right, rightMost[arr[i]]);
            res.add(right - left + 1);
            left = right + 1;
        }
        return res;
    }
}
