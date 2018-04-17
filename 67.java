class Solution {
    public String addBinary(String a, String b) {
        int jw = 0, ys = 0;
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        sa = sa.reverse();
        sb = sb.reverse();
        StringBuilder res = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        while (sa.length() < len)
            sa.append('0');
        while (sb.length() < len)
            sb.append('0');
        for (int i = 0; i < len; i++) {
            ys = ((sa.charAt(i) - '0') + (sb.charAt(i) - '0') + jw) % 2;
            jw = ((sa.charAt(i) - '0') + (sb.charAt(i) - '0') + jw) / 2;
            res.append(ys);
        }
        if (jw != 0)
            res.append(jw);
        return res.reverse().toString();
    }
}