class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= s)
                return 1;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s && j - i + 1 < min)
                    min = j - i + 1;
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}