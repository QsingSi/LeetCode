class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return 0;
        if (nums[0] >= nums.length - 1)
            return 1;
        int min = nums.length;
        int[] step = new int[nums.length];
        Arrays.fill(step, nums.length);
        step[0] = 0;
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            int fastIndex = i + 1;
            for (; j < nums.length && j <= i + nums[i]; j++) {
                if (step[i] + 1 < step[j])
                    step[j] = step[i] + 1;
                if (j + nums[j] >= fastIndex + nums[fastIndex])
                    fastIndex = j;
                if (j == nums.length - 1)
                    return step[j];
            }
            i = fastIndex;
        }
        return step[nums.length - 1];
    }
}