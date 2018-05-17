class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (h1, h2) -> h1[0] - h2[0]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++)
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}