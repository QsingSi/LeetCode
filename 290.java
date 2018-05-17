class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> mask = new HashMap<>();
        Map<String, Character> dummy = new HashMap<>();
        char[] arr = pattern.toCharArray();
        String[] tmp = str.split(" ");
        List<String> s = new ArrayList<>();
        // int index = 0;
        for (int i = 0; i < tmp.length; i++)
            if (!tmp[i].equals(" "))
                s.add(tmp[i]);
        if (arr.length != s.size())
            return false;
        for (int i = 0; i < arr.length; i++) {
            if (!mask.containsKey(arr[i]) && !dummy.containsKey(s.get(i))) {
                mask.put(arr[i], s.get(i));
                dummy.put(s.get(i), arr[i]);
            } else {
                if (dummy.containsKey(s.get(i)) && dummy.get(s.get(i)) != arr[i])
                    return false;
                if (mask.containsKey(arr[i]) && !mask.get(arr[i]).equals(s.get(i)))
                    return false;
            }
        }
        return true;
    }
}