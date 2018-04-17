class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        int res = 0, start = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        for (int i = start; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                res++;
            else
                break;
        }
        return res;
    }
}