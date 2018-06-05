/*
 * [640] Solve the Equation
 *
 * https://leetcode.com/problems/solve-the-equation/description/
 *
 * algorithms
 * Medium (38.81%)
 * Total Accepted:    9.8K
 * Total Submissions: 25.2K
 * Testcase Example:  '"x+5-3+x=6+x-2"'
 *
 *
 * Solve a given equation and return the value of x in the form of string
 * "x=#value". The equation contains only '+', '-' operation, the variable x
 * and its coefficient.
 *
 *
 *
 * If there is no solution for the equation, return "No solution".
 *
 *
 * If there are infinite solutions for the equation, return "Infinite
 * solutions".
 *
 *
 * If there is exactly one solution for the equation, we ensure that the value
 * of x is an integer.
 *
 *
 * Example 1:
 *
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 *
 *
 *
 * Example 2:
 *
 * Input: "x=x"
 * Output: "Infinite solutions"
 *
 *
 *
 * Example 3:
 *
 * Input: "2x=x"
 * Output: "x=0"
 *
 *
 *
 * Example 4:
 *
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 *
 *
 *
 * Example 5:
 *
 * Input: "x=x+2"
 * Output: "No solution"
 *
 *
 */
class Solution {
    public String solveEquation(String equation) {
        String[] equa = equation.split("=");
        if (equa[0].charAt(0) != '-')
            equa[0] = "+" + equa[0];
        if (equa[1].charAt(0) != '-')
            equa[1] = "+" + equa[1];
        int coef1 = 0, cons1 = 0, last = 0;
        boolean flag = false;
        for (int i = 1; i <= equa[0].length(); i++) {
            if (i == equa[0].length()) {
                if (flag) {
                    int sign = 1;
                    if (equa[0].charAt(last) == '-')
                        sign = -1;
                    coef1 += sign * ( (last + 1 < i - 1) ?  Integer.parseInt(equa[0].substring(last + 1, i - 1)) : 1);
                    flag = false;
                } else {
                    cons1 += Integer.parseInt(equa[0].substring(last, i));
                }
                break;
            }
            if (equa[0].charAt(i) == 'x')
                flag = true;
            if (equa[0].charAt(i) == '+' || equa[0].charAt(i) == '-') {
                if (flag) {
                    int sign = 1;
                    if (equa[0].charAt(last) == '-')
                        sign = -1;
                    coef1 += sign * ( (last + 1 < i - 1) ?  Integer.parseInt(equa[0].substring(last + 1, i - 1)) : 1);
                    flag = false;
                } else {
                    cons1 += Integer.parseInt(equa[0].substring(last, i));
                }
                last = i;
            }
        }
        last = 0;
        flag = false;
        for (int i = 1; i <= equa[1].length(); i++) {
            if (i == equa[1].length()) {
                if (flag) {
                    int sign = 1;
                    if (equa[1].charAt(last) == '+')
                        sign = -1;
                    coef1 += sign * ((last + 1 < i - 1) ? Integer.parseInt(equa[1].substring(last + 1, i - 1)) : 1);
                    flag = false;

                } else {
                    cons1 -= Integer.parseInt(equa[1].substring(last, i));
                }
                break;
            }
            if (equa[1].charAt(i) == 'x')
                flag = true;
            if (equa[1].charAt(i) == '+' || equa[1].charAt(i) == '-') {
                if (flag) {
                    int sign = 1;
                    if (equa[1].charAt(last) == '-')
                        sign = -1;
                    coef1 -= sign * ((last + 1 < i - 1) ? Integer.parseInt(equa[1].substring(last + 1, i - 1)) : 1);
                    flag = false;
                } else {
                    cons1 -= Integer.parseInt(equa[1].substring(last, i));
                }
                last = i;
            }
        }
        if (coef1 == 0 && cons1 != 0)
            return "No solution";
        if (coef1 == 0 && cons1 == 0)
            return "Infinite solutions";
        return "x=" + cons1 / -coef1;
    }
}
