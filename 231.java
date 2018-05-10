class Solution {
    public boolean isPowerOfTwo(int n) {
        int l = 0, r = 31;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (1 << mid == n)
                return true;
            else if (1 << mid < n)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}