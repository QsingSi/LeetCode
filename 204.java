class Solution {
    public int countPrimes(int n) {
        if (n < 2)
            return 0;
        boolean[] mask = new boolean[n];
        int cnt = 0;
        Arrays.fill(mask, true);
        mask[0] = mask[1] = false;
        for (int i = 2; i < n; i++) {
            if (mask[i]) {
                cnt++;
                for (int j = 2; j * i < n; j++)
                    mask[i * j] = false;
            }
        }
        return cnt;
    }
}