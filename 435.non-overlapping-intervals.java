/*
 * [435] Non-overlapping Intervals
 *
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 *
 * algorithms
 * Medium (41.24%)
 * Total Accepted:    22.4K
 * Total Submissions: 54.3K
 * Testcase Example:  '[[1,2]]'
 *
 *
 * Given a collection of intervals, find the minimum number of intervals you
 * need to remove to make the rest of the intervals non-overlapping.
 *
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start
 * point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't
 * overlap each other.
 *
 *
 *
 * Example 1:
 *
 * Input: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * Output: 1
 *
 * Explanation: [1,3] can be removed and the rest of intervals are
 * non-overlapping.
 *
 *
 *
 * Example 2:
 *
 * Input: [ [1,2], [1,2], [1,2] ]
 *
 * Output: 2
 *
 * Explanation: You need to remove two [1,2] to make the rest of intervals
 * non-overlapping.
 *
 *
 *
 * Example 3:
 *
 * Input: [ [1,2], [2,3] ]
 *
 * Output: 0
 *
 * Explanation: You don't need to remove any of the intervals since they're
 * already non-overlapping.
 *
 *
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a, b)-> {
            if (a.start == b.start)
                return a.end - b.end;
            else return a.start - b.start;
        });
        int cnt = 0;
        int start = 0;
        for (; start < intervals.length - 1;) {
            int i = start + 1;
            for (; i < intervals.length; i++) {
                if (intervals[i].start < intervals[start].end && intervals[i].end >= intervals[start].end)
                    cnt++;
                else if (intervals[i].end < intervals[start].end) {
                    cnt++;
                    start = i;
                    break;
                } else {
                    start = i;
                    break;
                }
            }
            if (i == intervals.length)
                break;
        }
        return cnt;
    }
}
