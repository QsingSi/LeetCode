/*
 * [402] Remove K Digits
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 * algorithms
 * Medium (25.82%)
 * Total Accepted:    32.3K
 * Total Submissions: 124.9K
 * Testcase Example:  '"1432219"\n3'
 *
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 *
 *
 * Note:
 *
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219
 * which is the smallest.
 *
 *
 *
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the
 * output must not contain leading zeroes.
 *
 *
 *
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with
 * nothing which is 0.
 *
 *
 */
class Solution {
    public String removeKdigits(String num, int k) {
        List<Character> st = new ArrayList<>();
        int digits = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!st.isEmpty() && st.get(st.size() - 1) > c && k > 0) {
                st.remove(st.size() - 1);
                k--;
            }
            st.add(c);
        }
        int idx = 0;
        while (idx < digits && st.get(idx) == '0')
            ++idx;
        if (idx == digits)
            return "0";
        StringBuilder res = new StringBuilder();
        while (idx < digits)
            res.append(st.get(idx++));
        return res.toString();
    }
}
