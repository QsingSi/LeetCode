/*
 * [409] Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (46.05%)
 * Total Accepted:    65.1K
 * Total Submissions: 141.3K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome
 * here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 *
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] hash = new int[128];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        boolean isOdd = false;
        int len = s.length();
        for (int h : hash) {
            if ((h & 1) == 1) {
                if (isOdd)
                    len--;
                isOdd = true;
            }
        }
        return len;
    }
}
