import java.util.Queue;
import java.util.Set;

/*
 * [895] Shortest Path to Get All Keys
 *
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/description/
 *
 * algorithms
 * Hard (31.98%)
 * Total Accepted:    2.1K
 * Total Submissions: 6.5K
 * Testcase Example:  '["@.a.#","###.#","b.A.B"]'
 *
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@"
 * is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are
 * locks.
 *
 * We start at the starting point, and one move consists of walking one space
 * in one of the 4 cardinal directions.  We cannot walk outside the grid, or
 * walk into a wall.  If we walk over a key, we pick it up.  We can't walk over
 * a lock unless we have the corresponding key.
 *
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase
 * letter of the first K letters of the English alphabet in the grid.  This
 * means that there is exactly one key for each lock, and one lock for each
 * key; and also that the letters used to represent the keys and locks were
 * chosen in the same order as the English alphabet.
 *
 * Return the lowest number of moves to acquire all keys.  If it's impossible,
 * return -1.
 *
 *
 *
 *
 * Example 1:
 *
 *
 * Input: ["@.a.#","###.#","b.A.B"]
 * Output: 8
 *
 *
 *
 * Example 2:
 *
 *
 * Input: ["@..aA","..B#.","....b"]
 * Output: 6
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
 * The number of keys is in [1, 6].  Each key has a different letter and opens
 * exactly one lock.
 *
 *
 *
 */
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestPathAllKeys(String[] grid) {
        char[][] g = new char[grid.length][grid[0].length()];
        int start = 0, allkeys = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                g[i][j] = grid[i].charAt(j);
                if (g[i][j] == '@')
                    start |= (i << 16) | (j << 8);
                if ('a' <= g[i][j] && g[i][j] <= 'f')
                    allkeys |= (1 << g[i][j] - 'a');
            }
        }
        q.offer(start);
        seen.add(start);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int top = q.poll();
                int x = top >> 16;
                int y = (top >> 8) & 0xFF;
                int keys = top & 0xFF;
                if (keys == allkeys) return step;
                for (int[] dir : dirs) {
                    int nkeys = keys;
                    int row = x + dir[0], col = y + dir[1];
                    if (row < 0 || row >= g.length || col < 0 || col >= g[0].length || g[row][col] == '#') continue;
                    if ('A' <= g[row][col] && g[row][col] <= 'F' && (nkeys & (1 << g[row][col] - 'A')) == 0) continue;
                    if (seen.add((row << 16) | (col << 8) | nkeys)) {
                        if ('a' <= g[row][col] && g[row][col] <= 'f') nkeys |= (1 << g[row][col] - 'a');
                        q.add((row << 16) | (col << 8) | nkeys);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
