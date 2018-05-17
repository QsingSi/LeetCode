class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1)
            return true;
        StringBuilder tmp = new StringBuilder();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++)
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                tmp.append(s.charAt(i));
        for (int i = 0; i < tmp.length() / 2; i++)
            if (tmp.charAt(i) != tmp.charAt(tmp.length() - 1 - i))
                return false;
        return true;
    }
}