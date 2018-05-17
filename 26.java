class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1 || nums[0] == nums[nums.length - 1])
            return 1;
        int unique = nums[0], number = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != unique) {
                unique = nums[i];
                number++;
            }
        }
        int len = nums.length;
        for (int i = 1; i < nums.length;) {
            if (nums[i] == nums[i - 1]) {
                int tmp = nums[i];
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - 1] = tmp;
                len--;
                if (len == number)
                    return len;
            } else {
                i++;
            }
        }
        return len;
    }
}