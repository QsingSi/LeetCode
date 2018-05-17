class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!mask.containsKey(nums1[i]))
                mask.put(nums1[i], 1);
            else
                mask.put(nums1[i], mask.get(nums1[i]) + 1);
        }
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (mask.containsKey(nums2[i])) {
                tmp.add(nums2[i]);
                mask.put(nums2[i], mask.get(nums2[i]) - 1);
                if (mask.get(nums2[i]) == 0)
                    mask.remove(nums2[i]);
            }
        }
        int[] res = new int[tmp.size()];
        int index = 0;
        for (Integer num : tmp)
            res[index++] = num;
        return res;
    }
}