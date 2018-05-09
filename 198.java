class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length + 2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            if (i - 3 >= 0)
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            else
                dp[i] = nums[i] + dp[i - 2];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}