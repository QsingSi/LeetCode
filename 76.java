class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || s.length() < t.length())
            return "";
        int min = s.length() + 1, start = 0, minStart = 0, end = 0;
        int len = s.length(), count = t.length();
        int[] map = new int[128];
        for (char ch : t.toCharArray())
            map[ch]++;
        while (end < len) {
            if (map[s.charAt(end)]-- > 0)
                count--;
            end++;
            while (count == 0) {
                if (end - start < min) {
                    minStart = start;
                    min = end - start;
                }
                map[s.charAt(start)]++;
                if (map[s.charAt(start)] > 0)
                    count++;
                start++;
            }
        }
        System.out.println(minStart);
        return min == s.length() + 1 ? "" : s.substring(minStart, minStart + min);
    }
}