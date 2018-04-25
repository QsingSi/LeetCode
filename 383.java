class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] s1 = ransomNote.toCharArray();
        char[] s2 = magazine.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        int i = 0, j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i] == s2[j])
                i++;
            j++;
        }
        if (i < s1.length)
            return false;
        return true;
    }
}