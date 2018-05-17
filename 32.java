class Solution {
    public int longestValidParentheses(String s) {
        int max = 0, start = 0;
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            else {
                if (st.empty())
                    start = i + 1;
                else {
                    st.pop();
                    max = st.empty() ? Math.max(max, i - start + 1) : Math.max(max, i - st.peek());
                }
            }
        }
        return max;
    }
}