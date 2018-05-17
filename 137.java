class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mask.containsKey(nums[i]))
                mask.put(nums[i], mask.get(nums[i]) + 1);
            else
                mask.put(nums[i], 1);
        }
        for (int i = 0; i < nums.length; i++)
            if (mask.get(nums[i]) == 1)
                return nums[i];
        return 0;
    }
}