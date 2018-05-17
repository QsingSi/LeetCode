class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int res = 1;
        int max = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1)
                max = Math.max(max, ++res);
            else if (nums[i] != nums[i - 1])
                res = 1;
            else
                continue;
        }
        return max;
    }
}