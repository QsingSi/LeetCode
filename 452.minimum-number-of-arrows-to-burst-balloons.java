/*
 * [452] Minimum Number of Arrows to Burst Balloons
 *
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 *
 * algorithms
 * Medium (44.49%)
 * Total Accepted:    22.7K
 * Total Submissions: 51.1K
 * Testcase Example:  '[[10,16],[2,8],[1,6],[7,12]]'
 *
 * There are a number of spherical balloons spread in two-dimensional space.
 * For each balloon, provided input is the start and end coordinates of the
 * horizontal diameter. Since it's horizontal, y-coordinates don't matter and
 * hence the x-coordinates of start and end of the diameter suffice. Start is
 * always smaller than end. There will be at most 104 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the
 * x-axis. A balloon with xstart and xend bursts by an arrow shot at x if
 * xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be
 * shot. An arrow once shot keeps travelling up infinitely. The problem is to
 * find the minimum number of arrows that must be shot to burst all balloons.
 *
 * Example:
 *
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons
 * [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two
 * balloons).
 *
 *
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b)-> {
            if (a[0] == b[0])
                return a[1] - b[1];
            else return a[0] - b[0];
        });
        int res = 0;
        for (int start = 0; start < points.length;) {
            res++;
            int i = start + 1;
            int right = points[start][1];
            for (; i < points.length; i++) {
                if (points[i][1] >= points[start][0] && points[i][1] <= points[start][1]) {
                    right = Math.min(right, points[i][1]);
                }
                if (points[i][0] > right) {
                    start = i;
                    break;
                }
            }
            if (i == points.length)
                break;
        }
        return res;
    }
}
