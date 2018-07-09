class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int i, j;
        for (i = 0; i < s.length(); i++) {
            for (j = 0; j < s.length(); j++) {
                if (i >= j)
                    dp[i][j] = true;
            }
        }
        int k = 1, max = 1, rf = 0, rt = 0;
        for (; k < s.length(); k++) {
            for (i = 0; k + i < s.length(); i++) {
                j = i + k;
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        max = k + 1;
                        rf = i;
                        rt = j;
                    }
                }
            }
        }
        return s.substring(rf, rt + 1);
    }
}
