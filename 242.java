class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] mask = new int[128];
        for (int i = 0; i < s.length(); i++)
            mask[s.charAt(i)]++;
        for (int i = 0; i < t.length(); i++)
            mask[t.charAt(i)]--;
        for (int i = 0; i < s.length(); i++)
            if (mask[s.charAt(i)] != 0)
                return false;
        return true;
    }
}