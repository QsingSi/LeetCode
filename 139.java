class Solution {
    public Set<Integer> mask = new HashSet<>();

    public boolean dfs(String s, List<String> dict) {
        if (s.length() == 0)
            return true;
        if (mask.contains(s.length()))
            return false;
        for (String word : dict) {
            if (s.startsWith(word)) {
                String rest = s.substring(word.length());
                if (dfs(rest, dict))
                    return true;
                mask.add(rest.length());
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict);
    }
}