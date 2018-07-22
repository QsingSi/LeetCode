class Solution {
    public double power(double x, long n) {
        if (Math.abs(x) >= 2 && n >= 1024) {
            if (x < 0 && n % 2 != 0)
                return -Double.MAX_VALUE;
            return Double.MAX_VALUE;
        }
        if (n == 0) {
            return 1.0;
        } else if (n % 2 == 0) {
            double half = power(x, n / 2);
            return half * half;
        } else {
            return x * power(x, n - 1);
        }
    }

    public double myPow(double x, int n) {
        //大于double最大值，返回double最大值即可
        if (x == 0.0 || x == 1.0)
            return x;
        if (n > 0)
            return power(x, n);
        return 1 / power(x, -(long) n);
    }
}
