/*
 * [423] Reconstruct Original Digits from English
 *
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
 *
 * algorithms
 * Medium (44.77%)
 * Total Accepted:    14.9K
 * Total Submissions: 33.2K
 * Testcase Example:  '"owoztneoer"'
 *
 * Given a non-empty string containing an out-of-order English representation
 * of digits 0-9, output the digits in ascending order.
 *
 * Note:
 *
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original
 * digits. That means invalid inputs such as "abc" or "zerone" are not
 * permitted.
 * Input length is less than 50,000.
 *
 *
 *
 * Example 1:
 *
 * Input: "owoztneoer"
 *
 * Output: "012"
 *
 *
 *
 * Example 2:
 *
 * Input: "fviefuro"
 *
 * Output: "45"
 *
 *
 */
class Solution {
    public String[] nums = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };
    private void deal(String num, int n, int[] cnt, char ch, StringBuilder res) {
        int len = cnt[ch];
        for (int i = 0; i < len; i++)
            res.append(n);
        for (int i = 0; i < num.length(); i++)
            cnt[num.charAt(i)] -= len;
    }
    public String originalDigits(String s) {
        int[] cnt = new int[128];
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray())
            cnt[ch]++;
        deal(nums[0], 0, cnt, 'z', res);
        deal(nums[2], 2, cnt, 'w', res);
        deal(nums[6], 6, cnt, 'x', res);
        deal(nums[7], 7, cnt, 's', res);
        deal(nums[5], 5, cnt, 'v', res);
        deal(nums[8], 8, cnt, 'g', res);
        deal(nums[3], 3, cnt, 't', res);
        deal(nums[4], 4, cnt, 'f', res);
        deal(nums[1], 1, cnt, 'o', res);
        deal(nums[9], 9, cnt, 'i', res);
        char[] arr = res.toString().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
