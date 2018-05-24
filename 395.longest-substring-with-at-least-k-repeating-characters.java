/*
 * [395] Longest Substring with At Least K Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (35.69%)
 * Total Accepted:    26.1K
 * Total Submissions: 73.1K
 * Testcase Example:  '"aaabb"\n3'
 *
 *
 * Find the length of the longest substring T of a given string (consists of
 * lowercase letters only) such that every character in T appears no less than
 * k times.
 *
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 *
 *
 *
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 * repeated 3 times.
 *
 *
 */
class Solution {
    public int max = -1;
    private int dfs(String s, int start, int end, int[] cnt, int k) {
        if (start > end)
            return 0;
        int i = start;
        for (; i <= end; i++) {
            if (cnt[s.charAt(i)] < k) {
                cnt[s.charAt(i)]--;
                break;
            }
        }
        if (i == end + 1)
            return i - start;
        int[] t1 = Arrays.copyOf(cnt, cnt.length);
        int[] t2 = Arrays.copyOf(cnt, cnt.length);
        for (int j = i + 1; j <= end; j++)
            t1[s.charAt(j)]--;
        for (int j = start; j < i; j++)
            t2[s.charAt(j)]--;
        return Math.max(dfs(s, start, i - 1, t1, k), dfs(s, i + 1, end, t2, k));
    }
    public int longestSubstring(String s, int k) {
        int[] cnt = new int[128];
        for (char c : s.toCharArray())
            cnt[c]++;
        return dfs(s, 0, s.length() - 1, cnt, k);
    }
}
