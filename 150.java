class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String tmp = tokens[i];
            int len = tmp.length() - 1;
            if (tmp.charAt(len) >= '0' && tmp.charAt(len) <= '9')
                num.push(Integer.valueOf(tmp));
            else {
                int second = num.pop();
                int first = num.pop();
                char op = tmp.charAt(0);
                if (op == '+')
                    num.push(first + second);
                if (op == '-')
                    num.push(first - second);
                if (op == '*')
                    num.push(first * second);
                if (op == '/')
                    num.push(first / second);
            }
        }
        return num.pop();
    }
}