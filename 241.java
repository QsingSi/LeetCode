class Solution {
    public Map<String, List<Integer>> mask;

    public List<Integer> dfs(String s) {
        List<Integer> res = mask.get(s);
        if (res != null)
            return res;
        res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0') {
                List<Integer> left = dfs(s.substring(0, i));
                List<Integer> right = dfs(s.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (s.charAt(i)) {
                        case '+':
                            res.add(l + r);
                            break;
                        case '-':
                            res.add(l - r);
                            break;
                        case '*':
                            res.add(l * r);
                            break;
                        }
                    }
                }
            }
        }
        if (res.isEmpty())
            res.add(Integer.valueOf(s));
        mask.put(s, res);
        return res;
    }

    public List<Integer> diffWaysToCompute(String input) {
        mask = new HashMap<>();
        return dfs(input);
    }
}