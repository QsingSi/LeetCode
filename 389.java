class Solution {
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        int i = 0;
        for (; i < s1.length; i++)
            if (s1[i] != s2[i])
                break;
        return s2[i];
    }
}