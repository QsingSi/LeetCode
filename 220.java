class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 2) {
            return k >= 1 & Math.abs((long) nums[1] - (long) nums[0]) <= (long) t;
        }
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                mask.put(nums[i], i);
            else {
                int tmp = nums[i];
                for (int j = tmp - t; j <= tmp + t; j++) {
                    if (mask.containsKey(j) && i - mask.get(j) <= k)
                        return true;
                }
                mask.put(tmp, i);
            }
        }
        return false;
    }
}