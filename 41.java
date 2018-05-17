class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> mask = new HashMap<Integer, Integer>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            mask.put(nums[i], 1);
            if (nums[i] > max)
                max = nums[i];
        }
        int res = 1;
        System.out.println(mask);
        System.out.println(max);
        for (int i = 1; i <= max + 1; i++) {
            if (!mask.containsKey(i)) {
                res = i;
                break;
            }
        }
        return res;
    }
}