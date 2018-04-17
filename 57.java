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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        intervals.add(newInterval);
        intervals.sort((h1, h2) -> (h1.start - h2.start));
        int len = intervals.size();
        for (int i = 0; i < len;) {
            boolean flag = false;
            int j = i + 1;
            for (; j < len; j++) {
                if (intervals.get(i).end < intervals.get(j).start) {
                    if (!flag) {
                        res.add(intervals.get(i));
                        flag = true;
                    }
                    break;
                } else if (intervals.get(i).end < intervals.get(j).end) {
                    intervals.get(i).end = intervals.get(j).end;
                    if (!flag) {
                        res.add(intervals.get(i));
                        flag = true;
                    }
                } else {
                    if (!flag) {
                        res.add(intervals.get(i));
                        flag = true;
                    }
                }
            }
            i = j;
            if (i == len - 1) {
                res.add(intervals.get(i));
                break;
            }
        }
        return res;
    }
}