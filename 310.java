class Solution {
    //超时为什么
    public int dfs(List<List<Integer>> edges, boolean[] visit, int now) {
        int depth = -1, len = edges.get(now).size();
        visit[now] = true;
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if (visit[edges.get(now).get(i)] == false) {
                flag = false;
                break;
            }
        }
        if (flag)
            return 1;
        for (int i = 0; i < len; i++) {
            if (!visit[edges.get(now).get(i)]) {
                depth = Math.max(1 + dfs(edges, visit, edges.get(now).get(i)), depth);
            }
        }
        return depth;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> res = new ArrayList<>();
        boolean[] visit = new boolean[n];
        int min = dfs(adj, visit, 0);
        res.add(0);
        for (int i = 1; i < n; i++) {
            Arrays.fill(visit, false);
            int now = dfs(adj, visit, i);
            if (now <= min) {
                if (now < min)
                    res.clear();
                res.add(i);
            }
            min = now < min ? now : min;
        }
        return res;
    }
}