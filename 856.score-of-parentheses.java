/*
 * [886] Score of Parentheses
 *
 * https://leetcode.com/problems/score-of-parentheses/description/
 *
 * algorithms
 * Medium (54.62%)
 * Total Accepted:    3.4K
 * Total Submissions: 6.1K
 * Testcase Example:  '"()"'
 *
 * Given a balanced parentheses string S, compute the score of the string based
 * on the following rule:
 *
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: "()"
 * Output: 1
 *
 *
 *
 * Example 2:
 *
 *
 * Input: "(())"
 * Output: 2
 *
 *
 *
 * Example 3:
 *
 *
 * Input: "()()"
 * Output: 2
 *
 *
 *
 * Example 4:
 *
 *
 * Input: "(()(()))"
 * Output: 6
 *
 *
 *
 *
 * Note:
 *
 *
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 *
 *
 *
 *
 *
 */
class Solution {
    private int helper(String s, int start, int end) {
        if (start + 1 == end)
            return 1;
        if (start >= end)
            return 0;
        int left = 0, index = start;
        for (; index <= end; index++) {
            if (s.charAt(index) == '(')
                left++;
            else left--;
            if (left == 0)
                break;
        }
        if (index == end)
            return 2 * helper(s, start + 1, end - 1);
        else return helper(s, start, index) + helper(s, index + 1, end);
    }
    public int scoreOfParentheses(String S) {
        return helper(S, 0, S.length() - 1);
    }
}
