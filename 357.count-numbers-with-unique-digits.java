/*
 * [357] Count Numbers with Unique Digits
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *
 * algorithms
 * Medium (46.16%)
 * Total Accepted:    47.8K
 * Total Submissions: 103.6K
 * Testcase Example:  '2'
 *
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 *
 *
 * ⁠   Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range
 * of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 *
 *
 * Credits:Special thanks to @memoryless for adding this problem and creating
 * all test cases.
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i > 10)
                return dp[10];
            int s = 9;
            for (int j = i; j > 1; j--)
                s *= (11 - j);
            dp[i] = dp[i - 1] + s;
        }
        return dp[n];
    }
}
