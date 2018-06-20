/*
 * [793] Swap Adjacent in LR String
 *
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/description/
 *
 * algorithms
 * Medium (28.73%)
 * Total Accepted:    4.5K
 * Total Submissions: 15.7K
 * Testcase Example:  '"X"\n"L"'
 *
 * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a
 * move consists of either replacing one occurrence of "XL" with "LX", or
 * replacing one occurrence of "RX" with "XR". Given the starting string start
 * and the ending string end, return True if and only if there exists a
 * sequence of moves to transform one string to the other.
 *
 * Example:
 *
 *
 * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * Output: True
 * Explanation:
 * We can transform start to end following these steps:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 *
 *
 * Note:
 *
 *
 * 1 <= len(start) = len(end) <= 10000.
 * Both start and end will only consist of characters in {'L', 'R', 'X'}.
 *
 */
class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length())
            return false;
        int lcnt = 0, rcnt = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L')
                lcnt++;
            if (start.charAt(i) == 'R')
                rcnt++;
            if (end.charAt(i) == 'L')
                lcnt--;
            if (end.charAt(i) == 'R')
                rcnt--;
        }
        if (lcnt != 0 || rcnt != 0)
            return false;
        int i = 0, j = 0;
        int n = start.length();
        while (i < n && j < n) {
            while (j < n && end.charAt(j) == 'X')
                ++j;
            while (i < n && start.charAt(i) == 'X')
                ++i;
            if (i == n && j == n)
                break;
            if (i == n || j == n || start.charAt(i) != end.charAt(j))
                return false;
            if (start.charAt(i) == 'R' && i > j)
                return false;
            else if (end.charAt(j) == 'L' && i < j)
                return false;
            ++i;
            ++j;
        }
        return true;
    }
}
