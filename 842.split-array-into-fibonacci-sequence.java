/*
 * [872] Split Array into Fibonacci Sequence
 *
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/description/
 *
 * algorithms
 * Medium (34.35%)
 * Total Accepted:    2.6K
 * Total Submissions: 7.6K
 * Testcase Example:  '"123456579"'
 *
 * Given a string S of digits, such as S = "123456579", we can split it into a
 * Fibonacci-like sequence [123, 456, 579].
 *
 * Formally, a Fibonacci-like sequence is a list F of non-negative integers
 * such that:
 *
 *
 * 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer
 * type);
 * F.length >= 3;
 * and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
 *
 *
 * Also, note that when splitting the string into pieces, each piece must not
 * have extra leading zeroes, except if the piece is the number 0 itself.
 *
 * Return any Fibonacci-like sequence split from S, or return [] if it cannot
 * be done.
 *
 * Example 1:
 *
 *
 * Input: "123456579"
 * Output: [123,456,579]
 *
 *
 * Example 2:
 *
 *
 * Input: "11235813"
 * Output: [1,1,2,3,5,8,13]
 *
 *
 * Example 3:
 *
 *
 * Input: "112358130"
 * Output: []
 * Explanation: The task is impossible.
 *
 *
 * Example 4:
 *
 *
 * Input: "0123"
 * Output: []
 * Explanation: Leading zeroes are not allowed, so "01", "2", "3" is not
 * valid.
 *
 *
 * Example 5:
 *
 *
 * Input: "1101111"
 * Output: [110, 1, 111]
 * Explanation: The output [11, 0, 11, 11] would also be accepted.
 *
 *
 * Note:
 *
 *
 * 1 <= S.length <= 200
 * S contains only digits.
 *
 */
class Solution {
    private boolean helper(String s, List<Integer> res, int end) {
        if (end == s.length() && res.size() >= 3)
            return true;
        for (int i = end; i < s.length(); i++) {
            if (s.charAt(end) == '0' && i > end)
                break;
            long num = Long.parseLong(s.substring(end, i + 1));
            if (num > Integer.MAX_VALUE)
                break;
            int size = res.size();
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2))
                break;
            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add((int)num);
                if (helper(s, res, i + 1))
                    return true;
                res.remove(res.size() - 1);
            }
        }
        return false;
    }
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        helper(S, res, 0);
        return res;
    }
}
