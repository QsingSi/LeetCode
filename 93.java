class Solution {
    public void dfs(String s, int k, List<String> res, String tmp) {
        if (s.isEmpty() || k == 4) {
            if (s.isEmpty() && k == 4)
                res.add(tmp.substring(1));
            return;
        }
        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
            String part = s.substring(0, i);
            if (Integer.valueOf(part) <= 255)
                dfs(s.substring(i), k + 1, res, tmp + '.' + part);

        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, res, "");
        return res;
    }
}