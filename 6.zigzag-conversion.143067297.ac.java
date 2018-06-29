class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int len = s.length(), k=0, gap = (numRows<<1)-2;
        char[] res = s.toCharArray();
        for(int j = 0; j<len;j+=gap){
            res[k++] = s.charAt(j);
        }
        for(int i=1;i<numRows-1;i++){
            int inter = (i<<1);
            for(int j=i;j<len;j+=inter){
                res[k++] = s.charAt(j);
                inter = gap - inter;
            }
        }
        for(int j=numRows-1;j<len; j+=gap)
            res[k++] = s.charAt(j);
        return new String(res);
    }
}
