class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i == 1) {
                tmp.add(i);
            } else {
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1)
                        tmp.add(1);
                    else {
                        tmp.add(res.get(i - 2).get(j - 1) + res.get(i - 2).get(j));
                    }
                }
            }
            res.add(tmp);
        }
        return res;
    }
}