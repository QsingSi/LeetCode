class Solution {
    public boolean judge(int num) {
        while (num % 2 == 0 || num % 3 == 0 || num % 5 == 0) {
            if (num % 2 == 0)
                num /= 2;
            if (num % 3 == 0)
                num /= 3;
            if (num % 5 == 0)
                num /= 5;
        }
        return num == 1;
    }

    public boolean isUgly(int num) {
        if (num <= 0)
            return false;
        return num == 1 ? true : judge(num);
    }
}