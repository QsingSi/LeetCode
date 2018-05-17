/*
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (41.79%)
 * Total Accepted:    57.5K
 * Total Submissions: 137.6K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 *
 *
 */
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        char[] arr1 = sb1.reverse().toString().toCharArray();
        StringBuilder sb2 = new StringBuilder(num2);
        char[] arr2 = sb2.reverse().toString().toCharArray();
        int jw = 0, ys = 0;
        int[] res = new int[Math.max(arr1.length, arr2.length) + 1];
        int i = 0;
        for (; i < arr1.length && i < arr2.length; i++) {
            ys = (arr1[i] - '0' + arr2[i] - '0' + jw) % 10;
            jw = (arr1[i] - '0' + arr2[i] - '0' + jw) / 10;
            res[i] = ys;
        }
        if (i == arr1.length) {
            while (i < arr2.length) {
                res[i] = (arr2[i] - '0' + jw) % 10;
                jw = (arr2[i] - '0' + jw) / 10;
                i++;
            }
        }
        if (i == arr2.length) {
            while (i < arr1.length) {
                res[i] = (arr1[i] - '0' + jw) % 10;
                jw = (arr1[i] - '0' + jw) / 10;
                i++;
            }
        }
        if (jw != 0)
            res[i] = jw;
        int end = res.length - 1;
        if (jw == 0)
            end--;
        String ss = "";
        for (; end >= 0; end--)
            ss += res[end];
        return ss;
    }
}
