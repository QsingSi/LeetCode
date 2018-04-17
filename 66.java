class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        for (int i = 0; i < digits.length; i++)
            res[i + 1] = digits[i];
        int jw = 1, ys = 0;
        for (int i = res.length - 1; i > 0; i--) {
            ys = (res[i] + jw) % 10;
            jw = (res[i] + jw) / 10;
            res[i] = ys;
        }
        if (jw != 0)
            res[0] = jw;
        if (res[0] != 0)
            return res;
        else
            return Arrays.copyOfRange(res, 1, res.length);
    }
}