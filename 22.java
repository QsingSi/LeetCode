class Solution {
    public List<String> result = new ArrayList<String>();
    public static char[] par = { '(', ')' };

    public void generate(int n, int index, char[] res) {
        if (index == n) {
            result.add(new String(res));
            return;
        }
        for (int i = 0; i < par.length; i++) {
            res[index] = par[i];
            generate(n, index + 1, res);
        }
    }

    public Boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else {
                if (st.empty()) {
                    return false;
                }
                if (s.charAt(i) == ')' && st.peek() != '(')
                    return false;
                st.pop();
            }
        }
        return st.empty();
    }

    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<String>();
        if (n == 1) {
            r.add("()");
            return r;
        }
        char[] res = new char[2 * n];
        generate(2 * n, 0, res);
        for (int i = 0; i < result.size(); i++) {
            String item = result.get(i);
            if (isValid(item)) {
                //System.out.println(isValid(item));
                r.add(item);
            }
        }
        return r;
    }
}