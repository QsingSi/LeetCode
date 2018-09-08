/*
 * [301] Remove Invalid Parentheses
 *
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (36.42%)
 * Total Accepted:    80.7K
 * Total Submissions: 221.5K
 * Testcase Example:  '"()())()"'
 *
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 *
 * Example 1:
 *
 *
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 *
 *
 * Example 2:
 *
 *
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 *
 *
 * Example 3:
 *
 *
 * Input: ")("
 * Output: [""]
 *
 *
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') l++;
            if (s.charAt(i) == ')') {
                if (l == 0) r++;
                else l--;
            }
        }
        dfs(s, 0, l, r, res);
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') count++;
            if (ch == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }

    private void dfs(String s, int index, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            if (isValid(s)) res.add(s);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) continue;
            String next = s.substring(0, i) + s.substring(i + 1);
            if (r > 0 && s.charAt(i) == ')') dfs(next, i, l, r - 1, res);
            if (l > 0 && s.charAt(i) == '(') dfs(next, i, l - 1, r, res);
        }
    }
}
