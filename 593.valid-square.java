/*
 * [593] Valid Square
 *
 * https://leetcode.com/problems/valid-square/description/
 *
 * algorithms
 * Medium (39.93%)
 * Total Accepted:    11.9K
 * Total Submissions: 29.8K
 * Testcase Example:  '[0,0]\n[1,1]\n[1,0]\n[0,1]'
 *
 * Given the coordinates of four points in 2D space, return whether the four
 * points could construct a square.
 *
 * The coordinate (x,y) of a point is represented by an integer array with two
 * integers.
 *
 * Example:
 *
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 *
 *
 *
 * ⁠Note:
 *
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal
 * angles (90-degree angles).
 * Input points have no order.
 *
 *
 */
class Solution {
    private int disOfTwoPoints(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0], dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] dis = new int[6];
        int index = 0;
        int[][] p = new int[][] {
            p1, p2, p3, p4
        };
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                dis[index++] = disOfTwoPoints(p[i], p[j]);
            }
        }
        Arrays.sort(dis);
        if (dis[5] == 0 || dis[5] != dis[4])
            return false;
        for (int i = 1; i < 4; i++)
            if (dis[i - 1] != dis[i])
                return false;
        return true;
    }
}
