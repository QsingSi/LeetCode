public class Solution {
    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        String tmp = "";
        String t = s.trim();
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == ' ') {
                if (tmp.length() != 0)
                    list.add(0, tmp);
                tmp = "";
                continue;
            }
            tmp += t.charAt(i);
        }
        System.out.println(tmp);
        list.add(0, tmp);
        String res = "";
        for (String w : list)
            res += (w + " ");
        return res.trim();
    }
}