class Solution {
    public void dfs(String s, List<String> tmp, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList(tmp));
            return;
        }
        for (int l = 1; l <= s.length(); l++) {
            if (l >= 2 && !judge(s.substring(0, l)))
                continue;
            tmp.add(s.substring(0, l));
            dfs(s.substring(l), tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    public boolean judge(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++)
            if (s.charAt(i) != s.charAt(len - 1 - i))
                return false;
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() > 0)
            dfs(s, new ArrayList<>(), res);
        return res;
    }
}