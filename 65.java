class Solution {
    //正则表达式学习一个
    public boolean isNumber(String s) {
        if (s.trim().isEmpty()) {
            return false;
        }
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
        if (s.trim().matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
}