class Solution {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i];
        }
        int max = sums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] > 0 ? sums[i - 1] + sums[i] : sums[i];
            if (sums[i] > max)
                max = sums[i];
        }
        return max;
    }
}