import java.util.Map;

/*
 * [447] Number of Boomerangs
 *
 * https://leetcode.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Easy (46.87%)
 * Total Accepted:    36.8K
 * Total Submissions: 78.4K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals
 * the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 *
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 *
 */
class Solution {
    public int dis(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int  j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                int d = dis(points[i], points[j]);
                mask.put(d, mask.getOrDefault(d, 0) + 1);
            }
            for (int val : mask.values()) {
                cnt += val * (val - 1);
            }
            mask.clear();
        }
        return cnt;
    }
}
