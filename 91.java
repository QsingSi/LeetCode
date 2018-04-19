class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] sum = new int[len + 1];
        sum[0] = sum[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int tmp = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (tmp <= 26 && tmp >= 1) {
                if (s.charAt(i) == '0') {
                    if (i + 1 < len && s.charAt(i + 1) == '0')
                        return 0;
                    sum[i + 1] = sum[i - 1];
                } else {
                    if (s.charAt(i - 1) == '0')
                        sum[i + 1] = sum[i];
                    else
                        sum[i + 1] = sum[i] + sum[i - 1];
                }
            } else if (s.charAt(i) == '0')
                return 0;
            else
                sum[i + 1] = sum[i];
        }
        return sum[len];
    }
}