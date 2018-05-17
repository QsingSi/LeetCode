class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0 || path.length() == 1)
            return path;
        List<String> st = new ArrayList<>();
        String[] pp = path.split("/");
        if (pp.length == 0)
            return "/";
        for (int i = 0; i < pp.length; i++) {
            if (pp[i].equals(".") || pp[i].isEmpty())
                continue;
            else if (pp[i].equals("..")) {
                if (st.size() > 0)
                    st.remove(st.size() - 1);
                else
                    continue;
            } else
                st.add(pp[i]);
        }
        String res = "/";
        for (int i = 0; i < st.size(); i++) {
            res += (st.get(i));
            if (i < st.size() - 1)
                res += "/";
        }
        return res;
    }
}