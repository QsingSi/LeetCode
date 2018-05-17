/*
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (39.36%)
 * Total Accepted:    109.3K
 * Total Submissions: 277.5K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 *
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 *
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 *
 *
 * Note:
 * The vowels does not include the letter "y".
 *
 */
class Solution {
    public String reverseVowels(String s) {
        Character[] arr = {
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
        };
        List<Character> yy = Arrays.asList(arr);
        StringBuilder tmp = new StringBuilder();
        boolean[] mask = new boolean[s.length()];
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            if (yy.contains(s1[i])) {
                tmp.append(s1[i]);
                mask[i] = true;
            }
        }
        String rr = tmp.toString();
        int index = rr.length() - 1;
        for (int i = 0; i < s1.length; i++) {
            if (mask[i]) {
                s1[i] = rr.charAt(index--);
            }
        }
        return new String(s1);
    }
}
