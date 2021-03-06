/*
 * [800] Letter Case Permutation
 *
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Easy (53.27%)
 * Total Accepted:    20K
 * Total Submissions: 37.7K
 * Testcase Example:  '"a1b2"'
 *
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.  Return a list of all possible
 * strings we could create.
 *
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 *
 *
 * Note:
 *
 *
 * S will be a string with length at most 12.
 * S will consist only of letters or digits.
 *
 */
class Solution {
    private void helper(char[] S, List<String> res, int index) {
        if (index == S.length) {
            res.add(new String(S));
            return;
        }
        helper(S, res, index + 1);
        if (Character.isLetter(S[index])) {
            S[index] ^= 1 << 5;
            helper(S, res, index + 1);
            S[index] ^= 1 << 5;
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(S.toCharArray(), res, 0);
        return res;
    }
}
