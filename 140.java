class Solution {
    public Set<Integer> mask = new HashSet<>();

    public void dfs(String s, List<String> dict, List<String> tmp, List<String> res) {
        if (s.length() == 0) {
            String ss = "";
            for (int i = 0; i < tmp.size(); i++) {
                ss += tmp.get(i);
                if (i < tmp.size() - 1)
                    ss += " ";
            }
            res.add(ss);
            return;
        }
        for (String w : dict) {
            if (s.startsWith(w)) {
                String rest = s.substring(w.length());
                tmp.add(w);
                dfs(rest, dict, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()])
            return res;
        dfs(s, wordDict, new ArrayList<>(), res);
        return res;
    }
}