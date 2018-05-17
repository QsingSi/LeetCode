class Solution {
    public String convertToTitle(int n) {
        n--;
        StringBuilder res = new StringBuilder();
        if (n == 0)
            res.append('A');
        while (n != 0) {
            res.append((char) ('A' + n % 26));
            n /= 26;
            if (n == 1)
                res.append('A');
            if (n > 0)
                n--;
        }
        return res.reverse().toString();
    }
}