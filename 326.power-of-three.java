/*
 * [326] Power of Three
 *
 * https://leetcode.com/problems/power-of-three/description/
 *
 * algorithms
 * Easy (40.81%)
 * Total Accepted:    128.1K
 * Total Submissions: 313.8K
 * Testcase Example:  '27'
 *
 *
 * ⁠   Given an integer, write a function to determine if it is a power of
 * three.
 *
 *
 * ⁠   Follow up:
 * ⁠   Could you do it without using any loop / recursion?
 *
 *
 * Credits:Special thanks to @dietpepsi for adding this problem and creating
 * all test cases.
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }
}
