class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mask.containsKey(nums[i]) && i - mask.get(nums[i]) <= k)
                return true;
            mask.put(nums[i], i);
        }
        return false;
    }
}