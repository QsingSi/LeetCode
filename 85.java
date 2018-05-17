class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int cLen = matrix[0].length;
        int rLen = matrix.length;
        int[] h = new int[cLen + 1];
        h[cLen] = 0;
        int max = 0;

        for (int row = 0; row < rLen; row++) {
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i <= cLen; i++) {
                if (i < cLen) {
                    if (matrix[row][i] == '1')
                        h[i] += 1;
                    else
                        h[i] = 0;
                }
                if (st.isEmpty() || h[st.peek()] <= h[i])
                    st.push(i);
                else {
                    while (!st.isEmpty() && h[i] < h[st.peek()]) {
                        int tp = st.pop();
                        max = Math.max(max, h[tp] * (st.isEmpty() ? i : (i - st.peek() - 1)));
                    }
                    st.push(i);
                }
            }
        }
        return max;
    }
}