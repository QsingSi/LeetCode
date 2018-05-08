class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        int tmp = 0;
        for (int i = 0; i < version1.length(); i++) {
            if (version1.charAt(i) == '.') {
                v1.add(tmp);
                tmp = 0;
            } else {
                tmp = tmp * 10 + version1.charAt(i) - '0';
            }
        }
        v1.add(tmp);
        tmp = 0;
        for (int i = 0; i < version2.length(); i++) {
            if (version2.charAt(i) == '.') {
                v2.add(tmp);
                tmp = 0;
            } else {
                tmp = tmp * 10 + version2.charAt(i) - '0';
            }
        }
        v2.add(tmp);
        int i = 0;
        for (; i < v1.size() && i < v2.size(); i++) {
            if (v1.get(i) == v2.get(i))
                continue;
            else
                return v1.get(i) > v2.get(i) ? 1 : -1;
        }
        if (v1.size() == v2.size())
            return 0;
        if (i == v1.size()) {
            while (i < v2.size())
                if (v2.get(i++) != 0)
                    return -1;
        } else {
            while (i < v1.size())
                if (v1.get(i++) != 0)
                    return 1;
        }
        return 0;
    }
}