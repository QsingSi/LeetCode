/*
 * [889] Buddy Strings
 *
 * https://leetcode.com/problems/buddy-strings/description/
 *
 * algorithms
 * Easy (26.22%)
 * Total Accepted:    6.7K
 * Total Submissions: 25.4K
 * Testcase Example:  '"ab"\n"ba"'
 *
 * Given two strings A and B of lowercase letters, return true if and only if
 * we can swap two letters in A so that the result equals B.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 *
 *
 *
 * Example 2:
 *
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 *
 *
 *
 * Example 3:
 *
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 *
 *
 *
 * Example 4:
 *
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 *
 *
 *
 * Example 5:
 *
 *
 * Input: A = "", B = "aa"
 * Output: false
 *
 *
 *
 *
 * Note:
 *
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 *
 *
 *
 *
 *
 *
 *
 */
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length())
            return false;
        boolean flag = A.equals(B);
        char[] arr1 = A.toCharArray();
        char[] arr2 = B.toCharArray();
        boolean dul = false;
        int cnt = 0, num[] = new int[128], first = -1, second = -1;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                cnt++;
                if (first == -1)
                    first = i;
                else second = i;
            }
        }
        if (!flag) {
            if (cnt != 2)
                return false;
            char tmp = arr1[first];
            arr1[first] = arr1[second];
            arr1[second] = tmp;
            return new String(arr1).equals(new String(arr2));
        } else {
            for (int i = 0; i < A.length(); i++) {
                num[A.charAt(i)]++;
                if (num[A.charAt(i)] >= 2)
                    dul = true;
            }
        }
        return dul;
    }
}
