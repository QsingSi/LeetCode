class Solution {
    public HashMap<List<Integer>, Integer> maskArr = new HashMap<List<Integer>, Integer>();
    public HashMap<Integer, Integer> mask = new HashMap<Integer, Integer>();

    public void generate(int index, int[] tmp, int[] nums, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> tt = new ArrayList<Integer>();
            for (int i = 0; i < index; i++)
                tt.add(tmp[i]);
            if (!maskArr.containsKey(tt)) {
                res.add(tt);
                maskArr.put(tt, 1);
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!mask.containsKey(i)) {
                tmp[index] = nums[i];
                mask.put(i, 1);
                generate(index + 1, tmp, nums, res);
                mask.remove(i);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0)
            return res;
        int[] tmp = new int[nums.length];
        generate(0, tmp, nums, res);
        return res;
    }
}