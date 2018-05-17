class Solution {
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    public HashMap<Integer, Integer> mask = new HashMap<Integer, Integer>();

    public void generate(int n, int index, int[] tmp, int[] nums) {
        if (index == n) {
            List<Integer> tt = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                tt.add(tmp[i]);
            }
            res.add(tt);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!mask.containsKey(nums[i])) {
                tmp[index] = nums[i];
                mask.put(nums[i], 1);
                generate(n, index + 1, tmp, nums);
                mask.remove(nums[i]);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return res;
        int[] tmp = new int[nums.length];
        generate(nums.length, 0, tmp, nums);
        return res;
    }
}