class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> tmp = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String w = s.substring(i, i + 10);
            if (tmp.contains(w))
                res.add(w);
            else
                tmp.add(w);
        }
        return new ArrayList<>(res);
    }
}