class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0)
            return res;
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }

    public void helper(List<String> res, String path, String num, int target, int pos, long eval, long multi) {
        if (pos == num.length()) {
            if (eval == target)
                res.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0')
                break;
            long cur = Long.valueOf(num.substring(pos, i + 1));
            if (pos == 0)
                helper(res, path + cur, num, target, i + 1, cur, cur);
            else {
                helper(res, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(res, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(res, path + "*" + cur, num, target, i + 1, eval - multi + multi * cur, multi * cur);
            }
        }
    }
}