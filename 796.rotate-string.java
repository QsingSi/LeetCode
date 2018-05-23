/*
 * [812] Rotate String
 *
 * https://leetcode.com/problems/rotate-string/description/
 *
 * algorithms
 * Easy (51.58%)
 * Total Accepted:    14.3K
 * Total Submissions: 27.8K
 * Testcase Example:  '"abcde"\n"cdeab"'
 *
 * We are given two strings, A and B.
 *
 * A shift on A consists of taking string A and moving the leftmost character
 * to the rightmost position. For example, if A = 'abcde', then it will be
 * 'bcdea' after one shift on A. Return True if and only if A can become B
 * after some number of shifts on A.
 *
 *
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 *
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 *
 *
 * Note:
 *
 *
 * A and B will have length at most 100.
 *
 *
 */
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.equals(B))
            return true;
        int cnt = A.length();
        StringBuilder sb = new StringBuilder(A);
        while (cnt-- > 0) {
            if (sb.toString().equals(B))
                return true;
            char tmp = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(tmp);
        }
        return false;
    }
}
