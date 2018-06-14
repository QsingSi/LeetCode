import java.util.Queue;

/*
 * [744] Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * algorithms
 * Medium (35.34%)
 * Total Accepted:    8.3K
 * Total Submissions: 23.3K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 *
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K.  How long will it take for all
 * nodes to receive the signal?  If it is impossible, return -1.
 *
 *
 * Note:
 *
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1  and 1 .
 *
 *
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] edges = new int[N + 1][N + 1];
        int tot =  0, cnt = 0;
        for (int[] edge : edges)
            Arrays.fill(edge, Integer.MAX_VALUE);
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            edges[u][v] = w;
        }
        boolean[] visited = new boolean[N + 1];
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        helper(K, N, visited, dis, edges);
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (i == K)
                continue;
            sum = Math.max(sum, dis[i]);
        }
        return sum == Integer.MAX_VALUE ? -1 : sum;
    }
    private void helper(int K, int N, boolean[] visited, int[] dis, int[][] edges) {
        dis[K] = 0;
        for (int i = 1; i <= N; i++) {
            int u = -1, min = Integer.MAX_VALUE;
            for (int j = 1; j <= N; j++) {
                if (visited[j] == false && dis[j] < min) {
                    u = j;
                    min = dis[j];
                }
            }
            if (u == -1)
                return;
            visited[u] = true;
            for (int v = 1; v <= N; v++) {
                if (visited[v] == false && edges[u][v] != Integer.MAX_VALUE && dis[u] + edges[u][v] < dis[v])
                    dis[v] = dis[u] + edges[u][v];
            }
        }
    }
}
