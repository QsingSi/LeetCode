class Solution {
    public void dfs(int[] nums, int index, List<Integer> tmp, List<List<Integer>> res) {

        if (index == nums.length) {
            res.add(new ArrayList(tmp));
            return;
        }
        tmp.add(nums[index]);
        dfs(nums, index + 1, tmp, res);
        tmp.remove(tmp.size() - 1);
        dfs(nums, index + 1, tmp, res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), res);
        //res.add(new ArrayList<Integer>());
        Set<List<Integer>> hs = new HashSet<>();
        hs.addAll(res);
        res.clear();
        res.addAll(hs);
        return res;
    }
}