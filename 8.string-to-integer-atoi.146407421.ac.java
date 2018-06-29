class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0)
            return 0;
        int index = 0, sign = 1;
        long res = 0;
        final int max = 2147483647, min = -2147483648;
        while(index < str.length()){
            if(str.charAt(index) != ' ')
                break;
            index++;
        }
        if(index == str.length())
            return 0;
        if(!(str.charAt(index) >='0' && str.charAt(index) <= '9' || str.charAt(index) == '+' || str.charAt(index) == '-'))
            return 0;
        else{
            int start = index, end = index;
            if(str.charAt(index) == '+')
                start++;
            if(str.charAt(index) == '-'){
                start++;
                sign *= -1;
            }
            end = start;
            while(end < str.length()){
                if(!(str.charAt(end) >= '0' && str.charAt(end) <= '9'))
                    break;
                end++;
            }
            //long res = 0;
            for(int i = start;i < end;i++){
                res = res * 10 + (str.charAt(i) - '0');
                if(res * sign > max)
                    return max;
                if(res * sign < min)
                    return min;
            }
            res = res * sign;
        }
        return (int)res;
    }
}
