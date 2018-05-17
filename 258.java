class Solution {
    public int addDigits(int num) {
        int tmp = num;
        while (tmp >= 10) {
            int sum = 0;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            tmp = sum;
        }
        return tmp;
    }
}