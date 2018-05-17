/*
 * [371] Sum of Two Integers
 *
 * https://leetcode.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (50.85%)
 * Total Accepted:    98K
 * Total Submissions: 192.7K
 * Testcase Example:  '1\n2'
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use
 * the operator + and -.
 *
 * Example:
 * Given a = 1 and b = 2, return 3.
 *
 *
 * Credits:Special thanks to @fujiaozhu for adding this problem and creating
 * all test cases.
 */
class Solution {
    public int add(int a, int b) {
        int sum = a;
        int carry = b;
        while (carry != 0) {
            int tmp = sum;
            sum = sum ^ carry;
            carry = (tmp & carry) << 1;
        }
        return sum;
    }
    public int getSum(int a, int b) {
        return add(a, b);
    }
}
