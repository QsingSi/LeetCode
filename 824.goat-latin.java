/*
 * [851] Goat Latin
 *
 * https://leetcode.com/problems/goat-latin/description/
 *
 * algorithms
 * Easy (56.31%)
 * Total Accepted:    6.2K
 * Total Submissions: 11K
 * Testcase Example:  '"I speak Goat Latin"'
 *
 * A sentence S is given, composed of words separated by spaces. Each word
 * consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language
 * similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of
 * the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first
 * letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the
 * sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets
 * "aa" added to the end and so on.
 *
 *
 * Return the final sentence representing the conversion from S to Goat
 * Latin. 
 *
 *
 *
 * Example 1:
 *
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 *
 * Example 2:
 *
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
 * hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 *
 *
 *
 * Notes:
 *
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between
 * each word.
 * 1 <= S.length <= 150.
 *
 */
class Solution {
    public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        int index = 1;
        String vowels = "aeiouAEIOU";
        int[] mask = new int[128];
        for (char c : vowels.toCharArray())
            mask[c]++;
        List<String> fuck = new ArrayList<>();
        for (String s : arr) {
            StringBuilder sb  = new StringBuilder(s);
            if (mask[s.charAt(0)] > 0) {
                sb.append("ma");
            } else {
                char c = sb.charAt(0);
                sb  = sb.deleteCharAt(0);
                sb.append(c);
                sb.append("ma");
            }
            int tmp = index++;
            while (tmp-- > 0)
                sb.append('a');
            fuck.add(sb.toString());
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < fuck.size(); i++) {
            res.append(fuck.get(i));
            if (i < fuck.size() - 1)
                res.append(' ');
        }
        return res.toString();
    }
}
