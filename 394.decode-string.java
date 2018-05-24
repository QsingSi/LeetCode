/*
 * [394] Decode String
 *
 * https://leetcode.com/problems/decode-string/description/
 *
 * algorithms
 * Medium (42.12%)
 * Total Accepted:    54.5K
 * Total Submissions: 129.3K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 *
 * Given an encoded string, return it's decoded string.
 *
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 *
 *
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 *
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 *
 */
class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        Stack<Integer> nums = new Stack<>();
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == ']') {
                StringBuilder sb  = new StringBuilder();
                while (!st.empty() && !st.peek().equals("[")) {
                    sb.insert(0, st.pop());
                }
                st.pop();
                int cnt = nums.pop();
                String tmp = sb.toString();
                while (--cnt > 0)
                    sb.append(tmp);
                st.push(sb.toString());
                i++;
            } else  if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = i + 1;
                for (; j < s.length(); j++)
                    if (s.charAt(j) == '[')
                        break;
                nums.push(Integer.valueOf(s.substring(i, j)));
                i = j;
            } else {
                st.push(s.substring(i, i + 1));
                ++i;
            }
        }
        while (!st.empty())
            res.insert(0, st.pop());
        return res.toString();
    }
}
