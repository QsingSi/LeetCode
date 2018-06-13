/*
 * [738] Monotone Increasing Digits
 *
 * https://leetcode.com/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (41.06%)
 * Total Accepted:    7K
 * Total Submissions: 16.9K
 * Testcase Example:  '10'
 *
 *
 * Given a non-negative integer N, find the largest number that is less than or
 * equal to N with monotone increasing digits.
 *
 * (Recall that an integer has monotone increasing digits if and only if each
 * pair of adjacent digits x and y satisfy x .)
 *
 *
 * Example 1:
 *
 * Input: N = 10
 * Output: 9
 *
 *
 *
 * Example 2:
 *
 * Input: N = 1234
 * Output: 1234
 *
 *
 *
 * Example 3:
 *
 * Input: N = 332
 * Output: 299
 *
 *
 *
 * Note:
 * N is an integer in the range [0, 10^9].
 *
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] arr = Integer.toString(N).toCharArray();
        int mark = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                mark = i - 1;
                arr[i - 1]--;
            }
        }
        for (int i = mark + 1; i < arr.length; i++)
            arr[i] = '9';
        return Integer.parseInt(new String(arr));
    }
}
