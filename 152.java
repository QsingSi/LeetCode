class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int tmp = nums[0];
        int firstNeg = 0;
        for (int i = 1; i < nums.length; i++) {
            if (tmp < 0 && firstNeg == 0)
                firstNeg = tmp;
            if (nums[i - 1] == 0 && nums[i] != 0) {
                tmp = nums[i];
                firstNeg = 0;
            } else {
                tmp *= nums[i];
            }
            if (tmp < 0 && firstNeg < 0)
                max = Math.max(max, tmp / firstNeg);
            else
                max = Math.max(max, tmp);
        }
        return max;
    }
}