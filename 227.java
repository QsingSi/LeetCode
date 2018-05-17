class Solution {
    public int calculate(String s) {
        List<String> pos = new ArrayList<>();
        Stack<Character> st = new Stack<>();
        int[] op = new int[128];
        op['+'] = op['-'] = 0;
        op['*'] = op['/'] = 1;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                int j = i + 1;
                for (; j < s.length(); j++)
                    if (s.charAt(j) > '9' || s.charAt(j) < '0')
                        break;
                pos.add(s.substring(i, j));
                i = j;
                continue;
            }
            if (s.charAt(i) == '(')
                st.push('(');
            else if (s.charAt(i) == ')') {
                while (st.peek() != '(')
                    pos.add(Character.toString(st.pop()));
                st.pop();
            } else {
                while (!st.empty() && op[st.peek()] >= op[s.charAt(i)])
                    pos.add(Character.toString(st.pop()));
                st.push(s.charAt(i));
            }
            i++;
        }
        while (!st.empty())
            pos.add(Character.toString(st.pop()));
        Stack<Integer> num = new Stack<>();
        for (int i = 0; i < pos.size(); i++) {
            String tmp = pos.get(i);
            if (tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/")) {
                int second = num.pop();
                int first = num.pop();
                if (tmp.equals("+"))
                    num.push(first + second);
                if (tmp.equals("-"))
                    num.push(first - second);
                if (tmp.equals("*"))
                    num.push(first * second);
                if (tmp.equals("/"))
                    num.push(first / second);
            } else
                num.push(Integer.valueOf(tmp));
        }
        return num.pop();
    }
}