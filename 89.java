class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> rs = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++)
            rs.add(i ^ i >> 1);
        return rs;
    }
}