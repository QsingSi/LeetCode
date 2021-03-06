/*
 * [803] Cheapest Flights Within K Stops
 *
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 *
 * algorithms
 * Medium (29.96%)
 * Total Accepted:    8.6K
 * Total Submissions: 28.6K
 * Testcase Example:  '3\n[[0,1,100],[1,2,100],[0,2,500]]\n0\n2\n1'
 *
 * There are n cities connected by m flights. Each fight starts from city u and
 * arrives at v with a price w.
 *
 * Now given all the cities and fights, together with starting city src and the
 * destination dst, your task is to find the cheapest price from src to dst
 * with up to k stops. If there is no such route, output -1.
 *
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as
 * marked red in the picture.
 *
 *
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph looks like this:
 *
 *
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as
 * marked blue in the picture.
 *
 * Note:
 *
 *
 * The number of nodes n will be in range [1, 100], with nodes labeled from 0
 * to n - 1.
 * The size of flights will be in range [0, n * (n - 1) / 2].
 * The format of each flight will be (src, dst, price).
 * The price of each flight will be in the range [1, 10000].
 * k is in the range of [0, n - 1].
 * There will not be any duplicated flights or self cycles.
 *
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int dis[] = new int[n], edges[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(edges[i], Integer.MAX_VALUE);
            dis[i] = Integer.MAX_VALUE;
        }
        for (int[] e : flights)
            edges[e[0]][e[1]] = e[2];
        int res = dfs(edges, src, src, dst, K, new int[n][K + 1]);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int[][] edges, int u, int src, int v, int K, int[][] memo) {
        if (u == v)
            return 0;
        if (K == 0 && u != src)
            return Integer.MAX_VALUE;
        if (memo[u][K] != 0)
            return memo[u][K];
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            if (edges[u][i] == Integer.MAX_VALUE)
                continue;
            int cost = dfs(edges, i, src, v, u == src ? K : K - 1, memo);
            if (cost != Integer.MAX_VALUE)
                dis = Math.min(dis, edges[u][i] + cost);
        }
        memo[u][K] = dis;
        return dis;
    }
}
