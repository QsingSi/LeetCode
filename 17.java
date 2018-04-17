class Solution {
    public static String[] strs = new String[10];
    public List<String> result = new ArrayList<String>();

    public void init() {
        strs[2] = "abc";
        strs[3] = "def";
        strs[4] = "ghi";
        strs[5] = "jkl";
        strs[6] = "mno";
        strs[7] = "pqrs";
        strs[8] = "tuv";
        strs[9] = "wxyz";
    }

    public void generate(int n, int index, char[] res, String digits) {
        if (index == n) {
            result.add(new String(res));
            return;
        }
        int num = digits.charAt(index) - '0';
        for (int i = 0; i < strs[num].length(); i++) {
            res[index] = strs[num].charAt(i);
            generate(n, index + 1, res, digits);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }
        init();
        char[] res = new char[digits.length()];
        generate(digits.length(), 0, res, digits);
        return result;
    }
}
