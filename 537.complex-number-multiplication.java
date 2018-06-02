/*
 * [537] Complex Number Multiplication
 *
 * https://leetcode.com/problems/complex-number-multiplication/description/
 *
 * algorithms
 * Medium (63.85%)
 * Total Accepted:    25.2K
 * Total Submissions: 39.5K
 * Testcase Example:  '"1+1i"\n"1+1i"'
 *
 *
 * Given two strings representing two complex numbers.
 *
 *
 * You need to return a string representing their multiplication. Note i2 = -1
 * according to the definition.
 *
 *
 * Example 1:
 *
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert
 * it to the form of 0+2i.
 *
 *
 *
 * Example 2:
 *
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert
 * it to the form of 0+-2i.
 *
 *
 *
 * Note:
 *
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and
 * b will both belong to the range of [-100, 100]. And the output should be
 * also in this form.
 *
 *
 */
class Solution {
    public String complexNumberMultiply(String a, String b) {
        int index1 = 0, index2 = 0;
        int len1 = a.length(), len2 = b.length();
        for (; index1 < len1; index1++)
            if (a.charAt(index1) == '+')
                break;
        for (; index2 < len2; index2++)
            if (b.charAt(index2) == '+')
                break;
        int real1 = Integer.parseInt(a.substring(0, index1)), com1 = Integer.parseInt(a.substring(index1 + 1, len1 - 1));
        int real2 = Integer.parseInt(b.substring(0, index2)), com2 = Integer.parseInt(b.substring(index2 + 1, len2 - 1));
        int resReal = real1 * real2 - com1 * com2;
        int resCom = real1 * com2 + real2 * com1;
        StringBuilder sb = new StringBuilder();
        sb.append(resReal).append('+');
        sb.append(resCom).append('i');
        return sb.toString();
    }
}
