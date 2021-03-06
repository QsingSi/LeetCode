/*
 * [556] Next Greater Element III
 *
 * https://leetcode.com/problems/next-greater-element-iii/description/
 *
 * algorithms
 * Medium (28.94%)
 * Total Accepted:    14K
 * Total Submissions: 48.3K
 * Testcase Example:  '12'
 *
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 *
 * Example 1:
 *
 *
 * Input: 12
 * Output: 21
 *
 *
 *
 *
 * Example 2:
 *
 *
 * Input: 21
 * Output: -1
 *
 *
 *
 *
 */
class Solution {
    public int nextGreaterElement(int n) {
        char[] num = Integer.toString(n).toCharArray();
        int i, j;
        for (i = num.length - 1; i > 0; i--) {
            if (num[i - 1] < num[i])
                break;
        }
        if (i == 0)
            return -1;
        int x = num[i - 1], smallest = i;
        for (j = i + 1; j < num.length; j++) {
            if (num[j] > x && num[j] < num[smallest])
                smallest = j;
        }
        char tmp = num[i - 1];
        num[i - 1] = num[smallest];
        num[smallest] = tmp;
        Arrays.sort(num, i, num.length);
        long val = Long.parseLong(new String(num));
        return val <= Integer.MAX_VALUE ? (int)val : -1;
    }
}
