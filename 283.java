class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                cnt++;

        for (int i = 0; i < nums.length;) {
            if (nums[i] == 0) {
                int j = i + 1;
                for (; j < nums.length; j++)
                    nums[j - 1] = nums[j];
                nums[j - 1] = 0;
                if (nums[i] != 0)
                    i++;
            } else
                i++;
            if (i == cnt)
                break;
        }
    }
}