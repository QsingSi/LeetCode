class Solution {
    public String largestNumber(int[] nums) {
        String[] tmp = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            tmp[i] = Integer.toString(nums[i]);
        Arrays.sort(tmp, (h1, h2) -> {
            String case1 = h1 + h2;
            String case2 = h2 + h1;
            return case1.compareTo(case2);
        });
        String res = "";
        for (int i = tmp.length - 1; i >= 0; i--)
            res += tmp[i];
        return res.charAt(0) == '0' ? "0" : res;
    }
}