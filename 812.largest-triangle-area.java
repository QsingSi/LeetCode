/*
 * [830] Largest Triangle Area
 *
 * https://leetcode.com/problems/largest-triangle-area/description/
 *
 * algorithms
 * Easy (53.05%)
 * Total Accepted:    4.4K
 * Total Submissions: 8.4K
 * Testcase Example:  '[[0,0],[0,1],[1,0],[0,2],[2,0]]'
 *
 * You have a list of points in the plane. Return the area of the largest
 * triangle that can be formed by any 3 of the points.
 *
 *
 * Example:
 * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * Output: 2
 * Explanation:
 * The five points are show in the figure below. The red triangle is the
 * largest.
 *
 *
 *
 *
 * Notes:
 *
 *
 * 3 <= points.length <= 50.
 * No points will be duplicated.
 * -50 <= points[i][j] <= 50.
 * Answers within 10^-6 of the true value will be accepted as correct.
 *
 *
 *
 */
class Solution {
    private double getArea(int[][] points, int i, int j, int k) {
        return (1.0 / 2) * (points[i][0] * points[j][1] + points[j][0] * points[k][1] + points[k][0] * points[i][1] - points[i][0] * points[k][1] - points[j][0] * points[i][1] - points[k][0] * points[j][1]);
    }
    public double largestTriangleArea(int[][] points) {
        double max = -1.0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                    double area = getArea(points, i, j, k);
                    if (area > max)
                        max = area;
                }
            }
        }
        return max;
    }
}
