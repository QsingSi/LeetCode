class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        double res = 1.;
        while (res * res <= (double) x) {
            res++;
        }
        return (int) res - 1;
    }
}