class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Map<Integer, Integer> mask = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            if (!mask.containsKey(nums1[i]))
                mask.put(nums1[i], 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (mask.containsKey(nums2[i])) {
                res.add(nums2[i]);
                mask.remove(nums2[i]);
            }
        }
        int[] r = new int[res.size()];
        int i = 0;
        for (Integer t : res)
            r[i++] = t;
        return r;
    }
}