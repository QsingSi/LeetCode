/*
 * [804] Rotated Digits
 *
 * https://leetcode.com/problems/rotated-digits/description/
 *
 * algorithms
 * Easy (50.90%)
 * Total Accepted:    9.1K
 * Total Submissions: 17.9K
 * Testcase Example:  '10'
 *
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X.  Each digit must be rotated
 * - we cannot choose to leave it alone.
 *
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8
 * rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each
 * other, and the rest of the numbers do not rotate to any other number and
 * become invalid.
 *
 * Now given a positive number N, how many numbers X from 1 to N are good?
 *
 *
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after
 * rotating.
 *
 *
 * Note:
 *
 *
 * N  will be in range [1, 10000].
 *
 *
 */
class Solution {
    public int rotatedDigits(int N) {
        String num = Integer.toString(N);
        int[] dp = new int[4];
        dp[0] = 4;
        dp[1] = 2 * 4 + 4 * 7;
        dp[2] = 4 * 7 * 7 + 2 * (3 * 4 + 4 * 7);
        int len  = num.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                if (num.charAt(i) <= '4') {
                    sum += 1;
                    break;
                } else if (num.charAt(i) <= '5') {
                    sum += 2;
                    break;
                } else if (num.charAt(i) <= '8') {
                    sum += 3;
                    break;
                }
                sum += 4;
                break;
            }
            sum += (num.charAt(i) - '0' - 1) * dp[len - i - 1];
        }
        return sum;
    }
}
