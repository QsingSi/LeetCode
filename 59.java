class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0)
            return res;
        int top = 0, left = 0;
        int bottom = n, right = n;
        int now = 1;
        int i = 0, j = 0;
        n *= n;
        while (now <= n) {
            while (j < right && now <= n) {
                res[i][j++] = now++;
            }
            top++;
            j--;
            while (++i < bottom && now <= n) {
                res[i][j] = now++;
            }
            right--;
            i--;
            while (--j >= left && now <= n) {
                res[i][j] = now++;
            }
            bottom--;
            j++;
            while (--i >= top && now <= n) {
                res[i][j] = now++;
            }
            left++;
            i++;
            j++;
        }
        return res;
    }
}