class Solution {
    public int numDistinct(String S, String T) {
        if (T.length() == 0)
            return 0;

        int[] counts = new int[T.length()];
        for (int indexS = 0; indexS < S.length(); indexS++) {
            char charS = S.charAt(indexS);
            for (int indexT = T.length() - 1; indexT >= 0; indexT--) {
                if (T.charAt(indexT) == charS) {
                    if (indexT == 0)
                        counts[0]++;
                    else
                        counts[indexT] += counts[indexT - 1];
                }
            }
        }

        return counts[counts.length - 1];
    }
}