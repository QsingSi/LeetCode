class Solution {
    //快速排序
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r || nums.length <= 1)
            return;
        int i = l, j = r;
        int tmp = nums[l];
        while (i < j) {
            while (i < j && nums[j] >= tmp)
                j--;
            while (i < j && nums[i] <= tmp)
                i++;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[l] = nums[i];
        nums[i] = tmp;
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
}