/*
 * [592] Fraction Addition and Subtraction
 *
 * https://leetcode.com/problems/fraction-addition-and-subtraction/description/
 *
 * algorithms
 * Medium (46.03%)
 * Total Accepted:    8.7K
 * Total Submissions: 18.8K
 * Testcase Example:  '"-1/2+1/2"'
 *
 * Given a string representing an expression of fraction addition and
 * subtraction, you need to return the calculation result in string format. The
 * final result should be irreducible fraction. If your final result is an
 * integer, say 2, you need to change it to the format of fraction that has
 * denominator 1. So in this case, 2 should be converted to 2/1.
 *
 * Example 1:
 *
 * Input:"-1/2+1/2"
 * Output: "0/1"
 *
 *
 *
 * Example 2:
 *
 * Input:"-1/2+1/2+1/3"
 * Output: "1/3"
 *
 *
 *
 * Example 3:
 *
 * Input:"1/3-1/2"
 * Output: "-1/6"
 *
 *
 *
 * Example 4:
 *
 * Input:"5/3+1/3"
 * Output: "2/1"
 *
 *
 *
 * Note:
 *
 * The input string only contains '0' to '9', '/', '+' and '-'. So does the
 * output.
 * Each fraction (input and output) has format ±numerator/denominator. If the
 * first input fraction or the output is positive, then '+' will be omitted.
 * The input only contains valid irreducible fractions, where the numerator and
 * denominator of each fraction will always be in the range [1,10]. If the
 * denominator is 1, it means this fraction is actually an integer in a
 * fraction format defined above.
 * The number of given fractions will be in the range [1,10].
 * The numerator and denominator of the final result are guaranteed to be valid
 * and in the range of 32-bit int.
 *
 *
 */
class Solution {
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else return gcd(b, a % b);
    }
    private String addTwoString(String a, String b) {
        int index = 0;
        for (; index < a.length(); index++)
            if (a.charAt(index) == '/')
                break;
        int fz1 = Integer.parseInt(a.substring(0, index));
        int fm1 = Integer.parseInt(a.substring(index + 1));
        for (index = 0; index < b.length(); index++)
            if (b.charAt(index) == '/')
                break;
        int fz2 =  Integer.parseInt(b.substring(0, index));
        int fm2 = Integer.parseInt(b.substring(index + 1));
        int fm = fm1;
        if (fm1 != fm2) {
            fm = fm1 * fm2;
            fz1 *= fm2;
            fz2 *= fm1;
        }
        int fz = fz1 + fz2;
        int gys = gcd(Math.abs(fz), Math.abs(fm));
        fz /= gys;
        fm /= gys;
        StringBuilder sb = new StringBuilder();
        sb.append(fz).append('/').append(fm);
        return sb.toString();
    }
    public String fractionAddition(String expression) {
        String res = "0/1";
        int last = 0;
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                res = addTwoString(res, expression.substring(last, i));
                last = i;
            }
        }
        res = addTwoString(res, expression.substring(last));
        return res;
    }
}
