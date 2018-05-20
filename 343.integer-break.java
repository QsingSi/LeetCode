/*
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (46.58%)
 * Total Accepted:    58.2K
 * Total Submissions: 124.8K
 * Testcase Example:  '2'
 *
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 *
 *
 *
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10
 * = 3 + 3 + 4).
 *
 *
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 *
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 */
class Solution {
    public int integerBreak(int n) {
        int pro = 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        while (n > 4) {
            pro *= 3;
            n -= 3;
        }
        pro *= n;
        return pro;
    }
}
