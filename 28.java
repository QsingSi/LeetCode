class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0)
            return 0;
        if (haystack.length() == 0 || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0)
            return 0;
        int res = -1;
        int start = haystack.indexOf(needle.charAt(0));
        if (start == -1)
            return start;
        while (start < haystack.length()) {
            int needleIndex = 0;
            int end = start;
            while (end < haystack.length() && needleIndex < needle.length()
                    && haystack.charAt(end) == needle.charAt(needleIndex)) {
                end++;
                needleIndex++;
            }
            if (needleIndex == needle.length())
                return start;
            start = haystack.indexOf(needle.charAt(0), start + 1);
            if (start == -1)
                return start;
        }
        return res;
    }
}