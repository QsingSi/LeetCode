/*
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (60.48%)
 * Total Accepted:    248.5K
 * Total Submissions: 410.9K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and returns the string
 * reversed.
 *
 *
 * Example:
 * Given s = "hello", return "olleh".
 *
 */
class Solution {
    public String reverseString(String s) {
        StringBuilder res = new StringBuilder(s);
        return res.reverse().toString();
    }
}
