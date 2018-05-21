/*
 * [372] Super Pow
 *
 * https://leetcode.com/problems/super-pow/description/
 *
 * algorithms
 * Medium (34.79%)
 * Total Accepted:    21.2K
 * Total Submissions: 61K
 * Testcase Example:  '2\n[3]'
 *
 *
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is
 * an extremely large positive integer given in the form of an array.
 *
 *
 * Example1:
 *
 * a = 2
 * b = [3]
 *
 * Result: 8
 *
 *
 *
 * Example2:
 *
 * a = 2
 * b = [1,0]
 *
 * Result: 1024
 *
 *
 *
 * Credits:Special thanks to @Stomach_ache for adding this problem and creating
 * all test cases.
 */
class Solution {
    final int k = 1337;
    public int superPow(int a, int[] b) {
        int fac = a % k, l = b.length;
        int[] dp = new int[l];
        dp[0] = pMod(fac, b[l - 1]);
        for (int i = 1; i < l; i++) {
            fac = pMod(fac, 10);
            dp[i] = dp[i - 1] * pMod(fac, b[l - i - 1]) % k;
        }
        return dp[l - 1];
    }
    private int pMod(int a, int b) {
        return b == 0 ? 1 % k : b == 1 ? a % k : a % k * pMod(a, b - 1) % k;
    }
}
