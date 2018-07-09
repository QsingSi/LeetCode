class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        boolean[] mask = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            Arrays.fill(mask, false);
            for (; j < s.length(); j++) {
                if (mask[s.charAt(j)] == false)
                    mask[s.charAt(j)] = true;
                else break;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}
