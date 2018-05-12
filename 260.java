class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!mask.containsKey(nums[i]))
                mask.put(nums[i], 1);
            else
                mask.put(nums[i], mask.get(nums[i]) + 1);
        }
        Iterator iter = mask.entrySet().iterator();
        int[] res = new int[2];
        int index = 0;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            int val = (int) entry.getValue();
            if (val == 1)
                res[index++] = (int) entry.getKey();
        }
        return res;
    }
}