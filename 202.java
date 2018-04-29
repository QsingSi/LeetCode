class Solution {
    public boolean isHappy(int n) {
        int sum = n;
        int cnt = 100;
        while (sum != 1) {
            if (cnt-- == 0)
                return false;
            int tmp = sum;
            sum = 0;
            while (tmp != 0) {
                sum += (tmp % 10) * (tmp % 10);
                tmp /= 10;
            }
        }
        return true;
    }
}