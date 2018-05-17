class Solution {
    public int dfs(int start, int end, int[][] dp) {
        if (start > end) {
            dp[start][end] += 0;
            return dp[start][end];
        }
        if (start == end) {
            dp[start][start] = 1;
            return dp[start][start];
        }
        if (dp[start][end] > 0)
            return dp[start][end];
        for (int i = start; i <= end; i++) {
            dp[start][i - 1] = dfs(start, i - 1, dp);
            dp[i + 1][end] = dfs(i + 1, end, dp);
            if (dp[start][i - 1] > 0 && dp[i + 1][end] > 0)
                dp[start][end] += dp[start][i - 1] * dp[i + 1][end];
            else
                dp[start][end] += Math.max(dp[start][i - 1], dp[i + 1][end]);
        }
        return dp[start][end];
    }

    public int numTrees(int n) {
        int[][] dp = new int[n + 2][n + 2];
        return dfs(1, n, dp);
    }
}