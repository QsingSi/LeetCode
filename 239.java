class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[nums.length];
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i + k <= nums.length; i++) {
            int max = -1;
            for (int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            res[i] = max;
        }
        return res;
    }
}