class Solution {
    public int calculate(String s) {
        List<String> pos = new ArrayList<>();
        Stack<Character> st = new Stack<>();
        int tmp = 0;
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
            if (s.charAt(i) == ')') {
                while (st.peek() != '(')
                    pos.add(Character.toString(st.pop()));
                st.pop();
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                while (!st.empty() && (st.peek() == '+' || st.peek() == '-'))
                    pos.add(Character.toString(st.pop()));
                st.push(s.charAt(i));
            }
            i++;
        }
        while (!st.empty())
            pos.add(Character.toString(st.pop()));
        Stack<Integer> num = new Stack<>();
        for (int i = 0; i < pos.size(); i++) {
            if (pos.get(i).equals("+") || pos.get(i).equals("-")) {
                int second = num.pop();
                int first = num.pop();
                if (pos.get(i).equals("+"))
                    num.push(first + second);
                else
                    num.push(first - second);
            } else
                num.push(Integer.valueOf(pos.get(i)));
        }
        return num.pop();
    }
}