class Solution {
    public int hIndex(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= n)
                cnt[n - 1]++;
            else if (nums[i] >= 1)
                cnt[nums[i] - 1]++;
        }
        int pre = 0;
        for (int i = n; i >= 1; i--) {
            pre += cnt[i - 1];
            if (pre >= i)
                return i;
        }
        return 0;
    }
}