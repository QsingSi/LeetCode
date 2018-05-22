/*
 * [866] Rectangle Overlap
 *
 * https://leetcode.com/problems/rectangle-overlap/description/
 *
 * algorithms
 * Easy (37.79%)
 * Total Accepted:    2.3K
 * Total Submissions: 6.2K
 * Testcase Example:  '[0,0,2,2]\n[1,1,3,3]'
 *
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are
 * the coordinates of its bottom-left corner, and (x2, y2) are the coordinates
 * of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive.  To be
 * clear, two rectangles that only touch at the corner or edges do not
 * overlap.
 *
 * Given two rectangles, return whether they overlap.
 *
 * Example 1:
 *
 *
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 *
 *
 * Notes:
 *
 *
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 *
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[2] <= rec2[0] || rec1[3] <= rec2[1])
            return false;
        int x1 = 0, x2 = 0, x3 = 0, x4 = 0;
        x1 = Math.max(rec1[0], rec2[0]);
        x2 = Math.max(rec1[1], rec2[1]);
        x3 = Math.min(rec1[2], rec2[2]);
        x4 = Math.min(rec1[3], rec2[3]);
        return (x4 - x2) * (x3 - x1) != 0;
    }
}
