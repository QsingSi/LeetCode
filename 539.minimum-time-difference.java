import java.util.Collections;

/*
 * [539] Minimum Time Difference
 *
 * https://leetcode.com/problems/minimum-time-difference/description/
 *
 * algorithms
 * Medium (46.14%)
 * Total Accepted:    17.2K
 * Total Submissions: 37.2K
 * Testcase Example:  '["23:59","00:00"]'
 *
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list.
 *
 * Example 1:
 *
 * Input: ["23:59","00:00"]
 * Output: 1
 *
 *
 *
 * Note:
 *
 * The number of time points in the given list is at least 2 and won't exceed
 * 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 *
 *
 */
class Solution {
    private int timeToMinutes(String t) {
        String[] time = t.split(":");
        int h = Integer.parseInt(time[0]), m = Integer.parseInt(time[1]);
        return h * 60 + m;
    }
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440)
            return 0;
        Collections.sort(timePoints);
        int min  = Integer.MAX_VALUE, pre = timeToMinutes(timePoints.get(timePoints.size() - 1)) - 1440;
        for (String s : timePoints) {
            min = Math.min(min, timeToMinutes(s) - pre);
            pre = timeToMinutes(s);
        }
        return min;
    }
}
