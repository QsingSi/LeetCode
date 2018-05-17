class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        List<Integer> st = new ArrayList<>();
        int cnt = 0;
        st.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (++cnt < 2)
                    st.add(nums[i]);
            } else {
                cnt = 0;
                st.add(nums[i]);
            }
        }
        for (int i = 0; i < st.size(); i++)
            nums[i] = st.get(i);
        return st.size();
    }
}