class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == val)
                break;
            index++;
        }
        int end = index;
        for (; end < nums.length; end++) {
            if (nums[end] != val)
                break;
        }
        if (index == nums.length)
            return nums.length;
        if (end == nums.length)
            return index;
        int swap = nums.length - 1;
        for (int i = index; i < end; i++, swap--) {
            int tmp = nums[i];
            nums[i] = nums[swap];
            nums[swap] = tmp;
        }
        return swap + 1;
    }
}