class Solution {
    public void dfs(int n, int cnt, int now, int k, List<Integer> tmp, List<List<Integer>> res) {
        if (cnt == k) {
            res.add(new ArrayList(tmp));
            return;
        }
        if (cnt > k)
            return;
        for (int i = now; i <= n; i++) {
            tmp.add(i);
            dfs(n, cnt + 1, i + 1, k, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tmp = new ArrayList<>();
        boolean[] mask = new boolean[n + 1];
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 0, 1, k, tmp, res);
        return res;
    }
}