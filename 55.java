class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return true;
        int target = nums.length - 1;
        int fastIndex = 0;
        for (int i = 0; i <= target;) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j + nums[j] >= target)
                    return true;
                if (j + nums[j] >= fastIndex + nums[fastIndex])
                    fastIndex = j;
            }
            i = fastIndex;
            if (nums[i] == 0)
                return false;
        }
        return false;
    }
}