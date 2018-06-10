/*
 * [670] Maximum Swap
 *
 * https://leetcode.com/problems/maximum-swap/description/
 *
 * algorithms
 * Medium (38.61%)
 * Total Accepted:    22.4K
 * Total Submissions: 58K
 * Testcase Example:  '2736'
 *
 *
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 *
 *
 * Example 1:
 *
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 *
 *
 *
 * Example 2:
 *
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 *
 *
 *
 *
 * Note:
 *
 * The given number is in the range [0, 108]
 *
 *
 */
class Solution {
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < arr.length; i++)
            buckets[arr[i] - '0'] = i;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 9; k > arr[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char tmp = arr[buckets[k]];
                    arr[buckets[k]] = arr[i];
                    arr[i] = tmp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}
