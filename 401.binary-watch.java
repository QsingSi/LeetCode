/*
 * [401] Binary Watch
 *
 * https://leetcode.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (44.73%)
 * Total Accepted:    47.8K
 * Total Submissions: 106.9K
 * Testcase Example:  '0'
 *
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and
 * the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the
 * right.
 *
 * For example, the above binary watch reads "3:25".
 *
 * Given a non-negative integer n which represents the number of LEDs that are
 * currently on, return all possible times the watch could represent.
 *
 * Example:
 * Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04",
 * "0:08", "0:16", "0:32"]
 *
 *
 * Note:
 *
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid,
 * it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for
 * example "10:2" is not valid, it should be "10:02".
 *
 *
 */
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] watch = new int[10];
        dfs(num, 0, watch, res);
        return res;
    }
    private void dfs(int num, int i, int[] watch, List<String> res) {
        if (num == 0) {
            String s = getTime(watch);
            if (s != null)
                res.add(s);
            return;
        }
        for (int j = i; j < 10; j++) {
            if (watch[j] == 1)
                continue;
            watch[j]  = 1;
            dfs(num - 1, j + 1, watch, res);
            watch[j] = 0;
        }
    }
    private String getTime(int[] watch) {
        int h = 0;
        for (int i = 3; i >= 0; i--)
            h = h * 2 + watch[i];
        if (h > 11)
            return null;
        int m = 0;
        for (int i = watch.length - 1; i >= 4; i--)
            m = m * 2 + watch[i];
        if (m > 59)
            return null;
        return h + ":" + (m < 10 ? "0" : "") + m;
    }
}
