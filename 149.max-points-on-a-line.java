import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;
/*
 * [149] Max Points on a Line
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (15.21%)
 * Total Accepted:    96.3K
 * Total Submissions: 633.3K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 *
 * Example 1:
 *
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 *
 *
 * Example 2:
 *
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 *
 */
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 2)
            return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<BigDecimal, Integer> mask = new HashMap<>();
            int samex = 1, samep = 0;
            for (int j = 0; j < points.length; j++) {
                if (j == i)
                    continue;
                if (points[j].x == points[i].x && points[j].y == points[i].y)
                    samep++;
                if (points[j].x == points[i].x)
                    samex++;
                else {
                    BigDecimal dy = new BigDecimal(points[j].y - points[i].y);
                    BigDecimal dx = new BigDecimal(points[j].x - points[i].x);
                    BigDecimal k = dy.divide(dx, MathContext.DECIMAL128);
                    mask.put(k, mask.getOrDefault(k, 1) + 1);
                    res = Math.max(mask.get(k) + samep, res);
                }
            }
            res = Math.max(res, samex);
        }
        return res;
    }
}
