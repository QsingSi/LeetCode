class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        int res = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend += Math.abs(divisor);
            if (divisor == -1)
                return Integer.MAX_VALUE;
            res++;
        }
        if (divisor == Integer.MIN_VALUE) {
            return res;
        }
        int sign1 = dividend > 0 ? 1 : -1;
        int sign2 = divisor > 0 ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while (divisor <= (dividend >> 1)) {
            divisor = divisor << 1;
            digit++;
        }
        while (digit >= 0) {
            if (dividend >= divisor) {
                res += 1 << digit;
                dividend -= divisor;
            }
            divisor = divisor >> 1;
            digit--;
        }
        return sign1 * sign2 * res;
    }
}