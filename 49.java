class Solution {
    public String sortedString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs.length == 0)
            return res;
        HashMap<String, List<String>> mask = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String nowString = sortedString(strs[i]);
            if (!mask.containsKey(nowString)) {
                List<String> tmp = new ArrayList<String>();
                tmp.add(strs[i]);
                mask.put(nowString, tmp);
            } else {
                mask.get(nowString).add(strs[i]);
            }
        }
        res.addAll(mask.values());
        return res;
    }
}