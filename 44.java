class Solution {
    //动态规划
    public static boolean matchChar(char c, char p) {
        return (p == '?' || p == c);
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int lens = s.length();
        int lenp = p.length();
        boolean[][] res = new boolean[lens + 1][lenp + 1];

        boolean flag = false;
        for (int i = 0; i <= lens; i++) {
            flag = true;
            for (int j = 0; j <= lenp; j++) {
                if (i == 0 && j == 0) {
                    res[i][j] = true;
                    flag = true;
                    continue;
                }
                if (j == 0) {
                    res[i][j] = false;
                    continue;
                }
                if (i == 0) {
                    res[i][j] = res[i][j - 1] && p.charAt(j - 1) == '*';
                } else {
                    res[i][j] = (matchChar(s.charAt(i - 1), p.charAt(j - 1)) && res[i - 1][j - 1])
                            || (p.charAt(j - 1) == '*' && (res[i][j - 1] || res[i - 1][j]));
                }
                if (res[i][j])
                    flag = true;
            }
            if (!flag)
                return false;
        }
        return res[lens][lenp];
    }
}

class Solution {
    //双指针
    public static boolean matchChar(char c, char p) {
        return (p == '?' || p == c);
    }

    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int indexS = 0;
        int indexP = 0;

        int lenS = s.length();
        int lenP = p.length();

        int preS = 0;
        int preP = 0;

        boolean back = false;

        while (indexS < lenS) {
            if (indexP < lenP && matchChar(s.charAt(indexS), p.charAt(indexP))) {
                indexS++;
                indexP++;
            } else if (indexP < lenP && p.charAt(indexP) == '*') {
                while (indexP < lenP && p.charAt(indexP) == '*') {
                    indexP++;
                }

                //P的最后一个是 *，表示可以匹配任何字符串
                if (indexP == lenP) {
                    return true;
                }

                // 记录下这个匹配位置。
                back = true;
                preS = indexS;
                preP = indexP;
            } else if (back) {
                indexS = ++preS;
                indexP = preP;
            } else {
                return false;
            }
        }

        // 跳过末尾的所有的*.
        while (indexP < lenP && p.charAt(indexP) == '*') {
            indexP++;
        }

        if (indexS == lenS && indexP == lenP) {
            return true;
        }

        return false;
    }
}