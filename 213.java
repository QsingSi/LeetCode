class Solution {
    public int rob1(int[] nums, int lo, int hi) {
        int[] dp = new int[nums.length];
        dp[lo] = nums[lo];
        dp[lo + 1] = nums[lo + 1];
        int max = Math.max(dp[lo], dp[lo + 1]);
        for (int i = lo + 2; i <= hi; i++) {
            if (i - lo >= 3)
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            else
                dp[i] = nums[i] + dp[i - 2];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
    }
}