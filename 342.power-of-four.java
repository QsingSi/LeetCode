/*
 * [342] Power of Four
 *
 * https://leetcode.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (39.25%)
 * Total Accepted:    86K
 * Total Submissions: 219K
 * Testcase Example:  '16'
 *
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 *
 * Example:
 * Given num = 16, return true.
 * Given num = 5, return false.
 *
 *
 * Follow up: Could you solve it without loops/recursion?
 *
 * Credits:Special thanks to @yukuairoy  for adding this problem and creating
 * all test cases.
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0)
            return false;
        while (num >= 4) {
            if (num % 4 != 0)
                return false;
            num /= 4;
        }
        return num == 1;
    }
}
