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
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder sb  = new StringBuilder();
                while (!st.empty() && st.peek() != '[') {
                    sb.insert(0, st.pop());
                }
                st.pop();
                int cnt = st.pop() - '0';
                String tmp = sb.toString();
                while (--cnt > 0)
                    sb.append(tmp);
                //res.insert(0, sb.toString());
                if (!st.empty() && st.peek() >= 'a' && st.peek() <= 'z')
                    sb.insert(0, st.pop());
                res.append(sb.toString());
            } else {
                st.push(s.charAt(i));
            }
        }
        return res.toString();
    }
}
