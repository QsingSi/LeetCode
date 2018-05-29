/*
 * [436] Find Right Interval
 *
 * https://leetcode.com/problems/find-right-interval/description/
 *
 * algorithms
 * Medium (41.54%)
 * Total Accepted:    18.8K
 * Total Submissions: 45.3K
 * Testcase Example:  '[[1,2]]'
 *
 *
 * Given a set of intervals, for each of the interval i, check if there exists
 * an interval j whose start point is bigger than or equal to the end point of
 * the interval i, which can be called that j is on the "right" of i.
 *
 *
 *
 * For any interval i, you need to store the minimum interval j's index, which
 * means that the interval j has the minimum start point to build the "right"
 * relationship for interval i. If the interval j doesn't exist, store -1 for
 * the interval i. Finally, you need output the stored value of each interval
 * as an array.
 *
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start
 * point.
 * You may assume none of these intervals have the same start point.
 *
 *
 *
 * Example 1:
 *
 * Input: [ [1,2] ]
 *
 * Output: [-1]
 *
 * Explanation: There is only one interval in the collection, so it outputs
 * -1.
 *
 *
 *
 * Example 2:
 *
 * Input: [ [3,4], [2,3], [1,2] ]
 *
 * Output: [-1, 0, 1]
 *
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 *
 *
 *
 * Example 3:
 *
 * Input: [ [1,4], [2,3], [3,4] ]
 *
 * Output: [-1, 2, -1]
 *
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
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
    public int[] findRightInterval(Interval[] intervals) {
        Map<Interval, Integer> mask = new HashMap<>();
        for (int i = 0; i < intervals.length; i++)
            mask.put(intervals[i], i);
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int[] res =  new int[intervals.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < intervals.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j].start >= intervals[i].end) {
                    flag = true;
                    int now = mask.get(intervals[i]), index = mask.get(intervals[j]);
                    res[now] = Math.min(res[now], index);
                    break;
                }
            }
            if (!flag)
                res[mask.get(intervals[i])] = -1;
        }
        return res;
    }
}
