class Solution {
    public void dfs(int n, int k, int now, List<List<Integer>> res, List<Integer> tmp) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList(tmp));
            return;
        }
        if (n > 9 * k || n < k)
            return;
        for (int i = now; i <= 9; i++) {
            tmp.add(i);
            dfs(n - i, k - 1, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, res, new ArrayList<>());
        return res;
    }
}