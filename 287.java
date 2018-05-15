class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> mask = new HashMap<>();
        int i = 0;
        for (; i < nums.length; i++) {
            if (!mask.containsKey(nums[i]))
                mask.put(nums[i], 1);
            else
                break;
        }
        return nums[i];
    }
}