class Solution {
    public String multiply(String num1, String num2) {
        if (num2.equals("0") || num1.equals("0"))
            return "0";
        if (num2.equals("1"))
            return num1;
        if (num1.equals("1"))
            return num2;
        int[] res = new int[220];
        for (int i = num2.length() - 1; i >= 0; i--) {
            List<Integer> tmp = new ArrayList<Integer>();
            int ys = 0, jw = 0;
            for (int k = 0; k < num2.length() - i - 1; k++)
                tmp.add(0);
            for (int j = num1.length() - 1; j >= 0; j--) {
                ys = ((num2.charAt(i) - '0') * (num1.charAt(j) - '0') + jw) % 10;
                jw = ((num2.charAt(i) - '0') * (num1.charAt(j) - '0') + jw) / 10;
                tmp.add(ys);
            }
            if (jw != 0)
                tmp.add(jw);
            int addys = 0, addjw = 0;
            for (int k = 0; k < tmp.size(); k++) {
                addys = (res[k] + tmp.get(k) + addjw) % 10;
                addjw = (res[k] + tmp.get(k) + addjw) / 10;
                res[k] = addys;
            }
            if (addjw != 0)
                res[tmp.size()] = addjw;
        }
        int lastNotZero = res.length - 1;
        while (res[lastNotZero] == 0)
            lastNotZero--;
        String result = "";
        while (lastNotZero >= 0)
            result += res[lastNotZero--];
        return result;
    }
}