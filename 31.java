class Solution {
    public void nextPermutation(int[] nums) {
        boolean needChange = false;
        int index = nums.length - 1;
        for (; index > 0; index--) {
            if (nums[index] > nums[index - 1]) {
                needChange = true;
                break;
            }
        }
        if (needChange) {
            int stop = index - 1;
            int min = nums[index];
            for (int i = nums.length - 1; i > stop; i--) {
                if (nums[i] > nums[stop] && nums[i] < min) {
                    min = nums[i];
                    index = i;
                }
            }
            int tmp = nums[index];
            for (int i = index; i > stop; i--) {
                nums[i] = nums[i - 1];
            }
            //降低一个目标移动之后并排序
            nums[stop] = tmp;
            Arrays.sort(nums, stop + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
    }
}