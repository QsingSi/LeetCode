public class Solution {
    List<Integer> res = new ArrayList<Integer>();
    Map<String, Integer> mem = new HashMap<>();
    int len;

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0)
            return res;
        len = words[0].length() * words.length;
        for (String i : words) {
            if (mem.containsKey(i))
                mem.put(i, mem.get(i) + 1);
            else
                mem.put(i, 1);
        }
        int pos = 0;
        while (true) {
            pos = find(s, pos, words);
            if (pos + len > s.length()) {
                return res;
            }
        }
    }

    int find(String s, int index, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int clen = words[0].length();
        //min是函数返回值，代表下次截取字符串的开头位置
        int min = len + index;
        //移位检查
        for (int i = 0; i < clen; i++) {
            map.clear();
            for (int j = words.length - 1; j >= 0; j--) {
                //left从后往前，index表示字符串开头，i表示偏移
                int left = index + i + j * clen, right = left + clen;
                if (right > s.length())
                    return min;
                String str = s.substring(left, right);
                if (!mem.containsKey(str)) {
                    //min的值取比较较小值
                    min = Math.min(min, right);
                    break;
                }
                if (!map.containsKey(str))
                    map.put(str, 1);
                else
                    map.put(str, map.get(str) + 1);
                if (mem.get(str) < map.get(str)) {
                    min = Math.min(min, right);
                    break;
                }
                if (j == 0) {
                    res.add(index + i);
                    //如果成功匹配，那么后移一个单词
                    min = Math.min(index + clen, min);
                }
            }
        }
        return min;
    }
}