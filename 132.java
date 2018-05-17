class Solution {
    public int minCut(String s) {
        int l = s.length();
        int[] cnt = new int[l];
        char[] c = s.toCharArray();
        boolean[][] pa = new boolean[l][l];

        for (int i = 0; i < l; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (j + 1 > i - 1 || pa[j + 1][i - 1])) {
                    pa[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cnt[j - 1] + 1);
                }
            }
            cnt[i] = min;
        }
        return cnt[l - 1];
    }
}