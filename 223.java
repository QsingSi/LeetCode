class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D - B) * (C - A);
        int area2 = (H - F) * (G - E);
        if (C <= E || G <= A || F >= D || H <= B)
            return area1 + area2;
        int a = Math.max(A, E);
        int b = Math.max(B, F);
        int c = Math.min(C, G);
        int d = Math.min(D, H);
        return area1 + area2 - (d - b) * (c - a);
    }
}