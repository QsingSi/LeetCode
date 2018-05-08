class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(-dungeon[m - 1][n - 1], 0) + 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 <= m - 1 && j + 1 <= n - 1) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                    ;
                } else if (i + 1 <= m - 1) {
                    dp[i][j] = dp[i + 1][j] - dungeon[i][j];
                } else if (j + 1 <= n - 1) {
                    dp[i][j] = dp[i][j + 1] - dungeon[i][j];
                }
                if (dp[i][j] <= 0)
                    dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }
}