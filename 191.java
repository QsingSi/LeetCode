public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String num = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < num.length(); i++)
            if (num.charAt(i) == '1')
                cnt++;
        return cnt;
    }
}