class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            String tmp = Integer.toString(nums[i]);
            int j = i + 1;
            for (; j < nums.length; j++)
                if (nums[j] != nums[j - 1] + 1)
                    break;
            if (j != i + 1)
                tmp += "->" + Integer.toString(nums[j - 1]);
            res.add(tmp);
            i = j;
        }
        return res;
    }
}