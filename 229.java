class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> mask = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!mask.containsKey(nums[i]))
                mask.put(nums[i], 1);
            else
                mask.put(nums[i], mask.get(nums[i]) + 1);
        }
        Iterator iter = mask.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            int val = (int) entry.getValue();
            if (val > len / 3)
                res.add((int) entry.getKey());
        }
        return res;
    }
}