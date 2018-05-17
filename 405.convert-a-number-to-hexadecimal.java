/*
 * [405] Convert a Number to Hexadecimal
 *
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 *
 * algorithms
 * Easy (41.07%)
 * Total Accepted:    34.7K
 * Total Submissions: 84.5K
 * Testcase Example:  '26'
 *
 *
 * Given an integer, write an algorithm to convert it to hexadecimal. For
 * negative integer, two’s complement method is used.
 *
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is
 * zero, it is represented by a single zero character '0'; otherwise, the first
 * character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed
 * integer.
 * You must not use any method provided by the library which converts/formats
 * the number to hex directly.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 *
 *
 *
 * Example 2:
 *
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 *
 *
 */
class Solution {
    public String toHex(int num) {
        if (num < 0)
            return Integer.toHexString(num);
        char[] nums = new char[16];
        char start = '0';
        for (int i = 0; i < 10; i++)
            nums[i] = start++;
        start = 'a';
        for (int i = 10; i < 16; i++)
            nums[i] = start++;
        StringBuilder res = new StringBuilder();
        do {
            res.insert(0, nums[num % 16]);
            num /= 16;
        } while (num != 0);
        return res.toString();
    }
}
