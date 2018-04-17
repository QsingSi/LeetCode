class Solution {
    //超时方法
    public int dfs(int[] heights, int left, int right) {
        if (left > right)
            return -1;
        if (left == right)
            return heights[left];
        int tmp = left;
        for (int i = left; i <= right; i++)
            if (heights[i] < heights[tmp])
                tmp = i;
        int max = -1;
        max = Math.max(max, (right - left + 1) * heights[tmp]);
        int l = dfs(heights, left, tmp - 1);
        int r = dfs(heights, tmp + 1, right);
        return l > r ? Math.max(max, l) : Math.max(max, r);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        return dfs(heights, 0, heights.length - 1);
    }
}