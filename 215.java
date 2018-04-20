class Solution {
    public int dfs(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int i = start, j = end;
        while (i < j) {
            while (nums[i] >= pivot && i < j)
                i++;
            if (i < j)
                nums[j] = nums[i];
            else
                break;
            while (nums[j] <= pivot && i < j)
                j--;
            if (i < j)
                nums[i] = nums[j];
            else
                break;
        }
        if (i - start == k)
            return pivot;
        else if (k < i - start)
            return dfs(nums, k, start, i - 1);
        else
            return dfs(nums, k - i + start - 1, i + 1, end);
    }

    public int findKthLargest(int[] nums, int k) {
        return dfs(nums, k - 1, 0, nums.length - 1);
    }
}