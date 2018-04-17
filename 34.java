class Solution {
    public int findFirstGreater(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int findFirstNotLess(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        if (nums.length == 0)
            return res;
        int left = findFirstNotLess(nums, 0, nums.length, target);
        int right = findFirstGreater(nums, 0, nums.length, target);
        if (left == nums.length)
            return res;
        if (nums[left] == target) {
            res[0] = left;
            res[1] = right - 1;
        }
        return res;
    }
}