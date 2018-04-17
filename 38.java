class Solution {
    public String countAndSay(int n) {
        String res = "1";
        Stack<Character> st = new Stack<Character>();
        for (int i = 1; i < n; i++) {
            for (int j = res.length() - 1; j >= 0; j--) {
                st.push(res.charAt(j));
            }
            res = "";
            while (!st.empty()) {
                char top = st.pop();
                int cnt = 1;
                while (!st.empty() && st.peek() == top) {
                    st.pop();
                    cnt++;
                }
                res = res + cnt + top;
            }
        }
        return res;
    }
}