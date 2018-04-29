class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mask.containsKey(nums[i]))
                return true;
            else
                mask.put(nums[i], 1);
        }
        return false;
    }
}