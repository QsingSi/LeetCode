class Solution {
    public int dfs(int n, int[] memo) {
        if (memo[n] != -1)
            return memo[n];
        int rt = (int) Math.sqrt(n), min = Integer.MAX_VALUE;
        for (int i = rt; i >= 1; i--)
            min = Math.min(dfs(n - i * i, memo), min);
        memo[n] = min + 1;
        return memo[n];
    }

    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        return dfs(n, memo);
    }
}