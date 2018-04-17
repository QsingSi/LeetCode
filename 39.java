class Solution {
    public void getResult(int target, int now, int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if (0 > target)
            return;
        if (0 == target) {
            res.add(new ArrayList(tmp));
            return;
        }
        for (int i = now; i < nums.length; i++) {
            if (0 > target - nums[i])
                break;
            if (i > now && nums[i] == nums[i - 1])
                continue;
            tmp.add(nums[i]);
            getResult(target - nums[i], i, nums, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        getResult(target, 0, candidates, tmp, res);
        return res;
    }
}