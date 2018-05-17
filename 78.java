class Solution {
    public void dfs(int[] nums, int cnt, int now, int len, List<Integer> tmp, List<List<Integer>> res){
        if(cnt == len){
            res.add(new ArrayList(tmp));
            return;
        }
        if(cnt > len)
            return;
        for(int i=now;i<nums.length;i++){
            tmp.add(nums[i]);
            dfs(nums, cnt + 1, i + 1, len, tmp, res);
            tmp.remove(tmp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        List<Integer> tmp = new ArrayList<>();
        res.add(tmp);
        for(int i=0;i<nums.length;i++)
            dfs(nums, 0, 0, i+1, tmp, res);
        
        return res;
    }
}